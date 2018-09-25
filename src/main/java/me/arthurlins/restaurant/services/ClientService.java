package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Client;
import me.arthurlins.restaurant.repositories.bridge.ClientDAO;
import me.arthurlins.restaurant.repositories.factories.ClientPersistenceFactory;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientService {

    private ClientDAO dao;

    public ClientService(){
        try {
            this.dao = new ClientPersistenceFactory().getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(){

        //Validation
        //clientDAO.insert(new Client());
    }
}
