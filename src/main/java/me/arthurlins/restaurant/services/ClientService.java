package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Client;
import me.arthurlins.restaurant.repositories.PersistenceFactory;
import me.arthurlins.restaurant.repositories.bridge.ClientDAO;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientService {

    private ClientDAO clientDAO;

    public ClientService(){
        this.clientDAO = (ClientDAO) new PersistenceFactory().create(Client.class);
    }

    public void insert(){

        //Validation
        clientDAO.insert(new Client());
    }
}
