package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.repositories.bridge.AnnounceDAO;
import me.arthurlins.restaurant.repositories.factories.AnnouncePersistenceFactory;

/**
 * Created by Arthur on 24/09/2018.
 */
public class AnnounceService {

    private AnnounceDAO dao;

    public AnnounceService() {
        this.dao = new AnnouncePersistenceFactory().getInstance();
    }


}
