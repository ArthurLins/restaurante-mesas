package me.arthurlins.restaurant.repositories.factories;

import me.arthurlins.restaurant.repositories.bridge.TableDAO;
import me.arthurlins.restaurant.repositories.impl.primary.TableDAOImpl;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TablePersistenceFactory implements IFactory<TableDAO> {

    public TablePersistenceFactory(){

    }

    public TableDAO getInstance() {
        return new TableDAOImpl();
    }
}
