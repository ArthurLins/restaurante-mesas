package me.arthurlins.restaurant.repositories;

import me.arthurlins.restaurant.model.Client;
import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.impl.ClientDAOImpl;
import me.arthurlins.restaurant.repositories.impl.ClientQueueDAOImpl;
import me.arthurlins.restaurant.repositories.impl.TableDAOimpl;

/**
 * Created by Arthur on 24/09/2018.
 */
public class PersistenceFactory {

    public Object create(Class clazz) {

        if (clazz == Client.class){
            return new ClientDAOImpl();
        } else if (clazz == Table.class){
            return new TableDAOimpl();
        } else if (clazz == ClientQueue.class){
            return new ClientQueueDAOImpl();
        } else {
            return null;
        }
    }

}
