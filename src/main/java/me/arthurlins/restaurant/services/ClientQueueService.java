package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;
import me.arthurlins.restaurant.repositories.factories.ClientQueuePersistenceFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueueService {



    private final int SKIP_COUNT = 2;
    private final int MARGIN = 0;

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
            if (qtdPersons < clientQueues.get(0).getPersonQtd()) {
                return null;
            }
            return clientQueues.get(0);
        }
        List<ClientQueue> currentQueue = clientQueues.parallelStream().collect(Collectors.toList());
        ClientQueue resultClient = null;
        for (ClientQueue clientQueue : currentQueue) {
            if (clientQueue.getSkippedCount() >= SKIP_COUNT) {
                resultClient = clientQueue;
            }
            if (clientQueue.getPersonQtd() == qtdPersons) {
                resultClient = clientQueue;
            }

            if (Math.abs(clientQueue.getPersonQtd() - qtdPersons) <= MARGIN) {
                resultClient = clientQueue;
            }

            if (resultClient != clientQueue) {
                clientQueue.skip();
            }
        }
        if (resultClient != null) {
            return resultClient;
        }
        Optional<ClientQueue> finalClient = currentQueue.parallelStream()
                .filter((clientQueue -> clientQueue.getPersonQtd() <= qtdPersons))
                .max(Comparator.comparing(ClientQueue::getId));
        return finalClient.orElse(null);
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
