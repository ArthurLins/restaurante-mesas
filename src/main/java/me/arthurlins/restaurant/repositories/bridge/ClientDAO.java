package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.Client;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface ClientDAO {
    void insert(Client Client) throws Exception;
    void edit(Client Client) throws Exception;
    void remove(Client Client);
    Client getById(int id);
    List<Client> view();
    List<Client> view(int qtdPerPage, int page);
}
