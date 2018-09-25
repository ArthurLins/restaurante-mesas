package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Table {

    private long id;
    private String name;
    private int capacity;
    private boolean taked;


    public Table(long id, String name, int capacity, boolean taked) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.taked = taked;
    }

    public Table(String name, int capacity, boolean taked) {
        this.name = name;
        this.capacity = capacity;
        this.taked = taked;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isTaked() {
        return taked;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTaked(boolean taked) {
        this.taked = taked;
    }
}

