package me.arthurlins.restaurant.repositories.factories;

import me.arthurlins.restaurant.repositories.bridge.ClientQueueDAO;
import me.arthurlins.restaurant.repositories.impl.primary.ClientQueueDAOImpl;

/**
 * Created by Arthur on 24/09/2018.
 */
public class ClientQueuePersistenceFactory implements IFactory<ClientQueueDAO> {

    public ClientQueuePersistenceFactory() {
    }

    public ClientQueueDAO getInstance() throws Exception {
        final String type = "primary";
        switch (type){
            case "primary":
                return new ClientQueueDAOImpl();
            //break;

            default:
                throw new Exception("No have factory");
        }
    }
}
