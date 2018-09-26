package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Table {

    private long id;
    private String name;
    private int capacity;
    private boolean taked;
    private int personsInTable;


    public Table(long id, String name, int capacity, boolean taked, int personsInTable) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.taked = taked;
        this.personsInTable = personsInTable;
    }

    public Table(String name, int capacity, boolean tacked, int personsInTable) {
        this(-1, name, capacity, tacked, personsInTable);
    }

    public void take(int personsInTable) {
        taked = true;
        this.personsInTable = personsInTable;
    }

    public void liberate() {
        taked = false;
        this.personsInTable = 0;
    }
    

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isTacked() {
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

    public void setTacked(boolean tacked) {
        this.taked = tacked;
    }

    public int getPersonsInTable() {
        return personsInTable;
    }
}

