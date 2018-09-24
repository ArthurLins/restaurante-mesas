package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.repositories.bridge.TableDAO;
import me.arthurlins.restaurant.repositories.factories.TablePersistenceFactory;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TableService {

    private TableDAO dao;

    public TableService() {
        this.dao = new TablePersistenceFactory().getInstance();
    }
}
