package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;
import me.arthurlins.restaurant.repositories.factories.ClientQueuePersistenceFactory;

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


    public ClientQueue getNext(){
        return null;
    }

}
