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

    public void insert(ClientQueue clientQueue) {

    }

    public void edit(ClientQueue clientQueue) {

    }

    public void remove(ClientQueue clientQueue) {

    }

    public ClientQueue getById(int id) {
        return null;
    }

    public List<ClientQueue> view() {
        return null;
    }

    public List<ClientQueue> view(int qtdPerPage, int page) {
        return null;
    }
}
