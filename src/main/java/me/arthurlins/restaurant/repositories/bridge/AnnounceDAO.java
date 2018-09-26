package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.Announce;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface AnnounceDAO {
    boolean isValidCode(Announce announce);

    Announce get(String code) throws Exception;

    void createCode(Announce announce);

    void attendAnnounce(Announce announce);
}
