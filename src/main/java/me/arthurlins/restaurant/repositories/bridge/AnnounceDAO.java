package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.Announce;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface AnnounceDAO {
    void insert(Announce Announce) throws Exception;
    void edit(Announce Announce) throws Exception;
    void remove(Announce Announce);
    Announce getById(int id);
    List<Announce> view();
    List<Announce> view(int qtdPerPage, int page);
}
