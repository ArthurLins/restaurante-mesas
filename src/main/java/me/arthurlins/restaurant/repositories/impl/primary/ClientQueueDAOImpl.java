package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueueDAOImpl implements ClientQueueDAO {

    private List<ClientQueue> clientQueues;

    public ClientQueueDAOImpl() {
        this.clientQueues = new ArrayList<ClientQueue>();
    }

    @Override
    public void storeEnqueue(ClientQueue clientQueue) throws Exception {

    }

    @Override
    public void storeDequeue(ClientQueue clientQueue) throws Exception {

    }

    @Override
    public ClientQueue getFrist() throws Exception {
        return null;
    }

    @Override
    public List<ClientQueue> view() {
        return null;
    }
}
