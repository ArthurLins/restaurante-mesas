package me.arthurlins.restaurant.model;

/**
 * Created by Arthur on 24/09/2018.
 */
public class Announce {

    private long id;
    private String title;
    private String message;

    public Announce(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Announce(long id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
