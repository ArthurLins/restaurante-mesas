package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.ClientQueue;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface ClientQueueDAO {

    void enqueue(ClientQueue clientQueue) throws Exception;

    void attend(ClientQueue clientQueue) throws Exception;

    //ClientQueue peek() throws Exception;
    List<ClientQueue> getQueue();
    //void edit(ClientQueue clientQueue) throws Exception;
    //void remove(ClientQueue clientQueue);
    //ClientQueue getById(int id);
    List<ClientQueue> view();
    //List<ClientQueue> view(int qtdPerPage, int page);
}
