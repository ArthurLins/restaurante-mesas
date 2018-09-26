package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;
import me.arthurlins.restaurant.repositories.factories.ClientQueuePersistenceFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueueService {



    private final int SKIP_COUNT = 2;
    private final int MARGIN = 1;


    private ClientQueueDAO dao;

    public ClientQueueService() {
        try {
            this.dao = new ClientQueuePersistenceFactory().getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void enqueue(ClientQueue clientQueue) throws Exception {
        dao.enqueue(clientQueue);
    }

    public ClientQueue getBestClientQueueTo(int qtdPersons) {
        List<ClientQueue> clientQueues = dao.getQueue();
        if (clientQueues == null) {
            return null;
        }
        if (clientQueues.size() == 1) {
            return clientQueues.get(0);
        }
        List<ClientQueue> skipped = new ArrayList<>();
        for (int i = 0; i <= SKIP_COUNT; i++) {
            ClientQueue cl = clientQueues.get(i);
            if (cl == null) {
                Optional<ClientQueue> optionalClientQueue = skipped
                        .parallelStream()
                        .max(Comparator.comparing(ClientQueue::getSkippedCount));
                return optionalClientQueue.orElse(null);
            }
            if (cl.getPersonQtd() == qtdPersons) {
                return cl;
            }
            if (cl.getPersonQtd() + MARGIN == qtdPersons) {
                return cl;
            }
            if (cl.getSkippedCount() >= SKIP_COUNT) {
                return cl;
            }
            cl.skip();
            skipped.add(cl);
        }
        return null;
    }

    public void attend(ClientQueue clientQueue) throws Exception {
        clientQueue.attend();
        dao.attend(clientQueue);
    }

    public List<ClientQueue> viewAll() {
        return dao.view();
    }

    public List<ClientQueue> viewQueue() {
        return dao.getQueue();
    }

}
