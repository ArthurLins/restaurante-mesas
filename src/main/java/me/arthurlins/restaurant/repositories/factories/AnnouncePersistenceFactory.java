package me.arthurlins.restaurant.repositories.factories;

import me.arthurlins.restaurant.repositories.bridge.AnnounceDAO;
import me.arthurlins.restaurant.repositories.impl.primary.AnnounceDAOImpl;

/**
 * Created by Arthur on 24/09/2018.
 */
public class AnnouncePersistenceFactory implements IFactory<AnnounceDAO> {

    public AnnouncePersistenceFactory() {
    }

    public AnnounceDAO getInstance() throws Exception {
        final String type = "primary";
        switch (type){
            case "primary":
                return new AnnounceDAOImpl();
            default:
                throw new Exception("No have factory");
        }
    }
}
