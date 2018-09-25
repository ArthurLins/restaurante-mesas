package me.arthurlins.restaurant.repositories.factories;

import me.arthurlins.restaurant.repositories.bridge.ClientDAO;
import me.arthurlins.restaurant.repositories.impl.primary.ClientDAOImpl;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientPersistenceFactory implements IFactory<ClientDAO> {

    public ClientPersistenceFactory() {
    }

    public ClientDAO getInstance() throws Exception {
        final String type = "primary";
        switch (type){
            case "primary":
                return new ClientDAOImpl();
            //break;
            default:
                throw new Exception("No have factory");
        }
    }
}
