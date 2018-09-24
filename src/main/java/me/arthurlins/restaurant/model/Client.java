package me.arthurlins.restaurant.model;

import me.arthurlins.restaurant.repositories.Unique;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Client implements Unique {

    private long id;

    public long getId() {
        return id;
    }
}
