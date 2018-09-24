package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Client;
import me.arthurlins.restaurant.repositories.bridge.ClientDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientDAOImpl implements ClientDAO {

    private List<Client> clients;

    public ClientDAOImpl() {
        this.clients = new ArrayList<Client>();
    }

    public void insert(Client client) {

    }

    public void edit(Client client) {

    }

    public void remove(Client client) {

    }

    public Client getById(int id) {
        return null;
    }

    public List<Client> view() {
        return null;
    }

    public List<Client> view(int qtdPerPage, int page) {
        return null;
    }
}
