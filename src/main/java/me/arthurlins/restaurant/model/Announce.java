package me.arthurlins.restaurant.model;

import me.arthurlins.restaurant.repositories.Unique;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Announce implements Unique {

    private long id;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
