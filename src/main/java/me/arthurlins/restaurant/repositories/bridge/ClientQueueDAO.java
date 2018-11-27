package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.ClientQueue;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface ClientQueueDAO {

    void enqueue(ClientQueue clientQueue) throws Exception;

    void attend(ClientQueue clientQueue) throws Exception;

    List<ClientQueue> getQueue();

    List<ClientQueue> view();

}
