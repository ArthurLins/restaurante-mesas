package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueue {

    private long id;
    private Client client;
    private ClientQueue next;
    private int skipedCount;

    public ClientQueue(long id, Client client, ClientQueue next, int skipedCount) {
        this.id = id;
        this.client = client;
        this.next = next;
        this.skipedCount = skipedCount;
    }

    public ClientQueue(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public ClientQueue getNext() {
        return next;
    }

    public int getSkipedCount() {
        return skipedCount;
    }

    public long getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setNext(Client next) {
        this.next = next;
    }

    public void setSkipedCount(int skipedCount) {
        this.skipedCount = skipedCount;
    }
}
