package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueueDAOImpl implements ClientQueueDAO {

    private AtomicLong increment;
    private List<ClientQueue> clientQueues;

    public ClientQueueDAOImpl() {
        this.clientQueues = new ArrayList<>();
        this.increment = new AtomicLong(0);
    }


    @Override
    public void enqueue(ClientQueue clientQueue) throws Exception {
        final ClientQueue finalClientQueue = clientQueue;
        if (clientQueue.getId() != -1) {
            if (clientQueues.parallelStream().anyMatch(ano -> ano.getId() == finalClientQueue.getId())) {
                throw new Exception("ClientQueue already exists.");
            }
        }
        clientQueue = new ClientQueue(increment.getAndIncrement(),
                clientQueue.getName(),
                clientQueue.getPhone(),
                clientQueue.getPersonQtd(),
                clientQueue.getSkippedCount(),
                clientQueue.isAttended(),
                clientQueue.getRandomCode());
        clientQueues.add(clientQueue);
    }

    @Override
    public void attend(ClientQueue clientQueue) throws Exception {
        Optional<ClientQueue> optionalClientQueue = clientQueues
                .parallelStream()
                .filter(cq -> cq.getId() == clientQueue.getId())
                .findFirst();
        if (!optionalClientQueue.isPresent()) {
            throw new Exception("ClientQueue not exists");
        }
        //To verify
        optionalClientQueue.get().setAttended(true);
    }

    @Override
    public List<ClientQueue> getQueue() {
        return clientQueues.parallelStream()
                .filter(c -> !c.isAttended())
                .sorted(Comparator.comparingLong(ClientQueue::getId))
                .collect(Collectors.toList());

    }


    @Override
    public List<ClientQueue> view() {
        return clientQueues;
    }
}
