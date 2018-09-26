package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Announce;
import me.arthurlins.restaurant.repositories.bridge.AnnounceDAO;
import me.arthurlins.restaurant.repositories.factories.AnnouncePersistenceFactory;
import me.arthurlins.restaurant.view.console.AnnounceConsoleView;

/**
 * Created by Arthur on 24/09/2018.
 */
public class AnnounceService {

    private AnnounceDAO dao;
    private AnnounceConsoleView view;


    public AnnounceService() {
        try {
            dao = new AnnouncePersistenceFactory().getInstance();
        } catch (Exception ignored) {
        }
    }

    public void setView(AnnounceConsoleView view) {
        this.view = view;
    }

    public void attendAnnounce(Announce announce) {
        dao.attendAnnounce(announce);
    }

    public Announce getAnnounce(String code) throws Exception {
        return dao.get(code);
    }

    public void makeNewAnnounce(Announce announce) {
        dao.createCode(announce);
        view.refreshAlert(announce.getCode());
    }


}
