package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;
import me.arthurlins.restaurant.repositories.factories.ClientQueuePersistenceFactory;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueueService {

    private ClientQueueDAO dao;

    public ClientQueueService() {
        this.dao = new ClientQueuePersistenceFactory().getInstance();
    }


}
