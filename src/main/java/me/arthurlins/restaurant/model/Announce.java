package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Announce {

    private long id;
    private ClientQueue clientQueue;
    private Table table;


    public Announce(ClientQueue clientQueue, Table table) {
        this(-1, clientQueue, table);
    }

    public Announce(long id, ClientQueue clientQueue, Table table) {
        this.id = id;
        this.clientQueue = clientQueue;
        this.table = table;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return clientQueue.getRandomCode();
    }

    public Table getTable() {
        return table;
    }

    public ClientQueue getClientQueue() {
        return clientQueue;
    }
}
