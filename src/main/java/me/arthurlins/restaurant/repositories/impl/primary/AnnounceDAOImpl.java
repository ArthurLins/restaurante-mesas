package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Announce;
import me.arthurlins.restaurant.repositories.bridge.AnnounceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Arthur on 24/09/2018.
 */
public class AnnounceDAOImpl implements AnnounceDAO {

    private AtomicLong increment;
    private List<Announce> announces;

    public AnnounceDAOImpl() {
        this.announces = new ArrayList<>();
        this.increment = new AtomicLong(0);
    }

    public void insert(Announce announce) throws Exception {
        final Announce finalAnnounce = announce;
        if (announces.parallelStream().anyMatch(ano -> ano.getId() == finalAnnounce.getId())){
            throw new Exception("Announce already exists.");
        }
        announce = new Announce(increment.getAndIncrement(), announce.getTitle(), announce.getMessage());
        announces.add(announce);
    }

    public void edit(Announce announce) throws Exception {
        Announce anon;
        for (int i = 0; i < announces.size(); i++){
             anon = announces.get(i);
             if (anon.getId() == announce.getId()){
                 announce = new Announce(announce.getId(), announce.getTitle(), announce.getMessage());
                 announces.set(i, announce);
                 return;
             }
        }
        throw new Exception("Announce not exists");
    }

    public void remove(Announce announce) {
        this.announces.removeIf(ano -> announce.getId() == ano.getId());
    }

    public Announce getById(int id) {
        final Optional<Announce> value = this.announces
                .parallelStream()
                .filter(announce -> announce.getId() == id)
                .findFirst();
        return value.orElse(null);
    }

    public List<Announce> view() {
        return this.announces;
    }

    public List<Announce> view(int qtdPerPage, int page) {
        //Todo..
        return null;
    }
}
