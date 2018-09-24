package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Announce;
import me.arthurlins.restaurant.repositories.bridge.AnnounceDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Arthur on 24/09/2018.
 */
public class AnnounceDAOImpl implements AnnounceDAO {

    private long increment = 0;
    private List<Announce> announces;

    public AnnounceDAOImpl() {
        this.announces = new ArrayList<Announce>();
    }

    public void insert(Announce announce) throws Exception {
        if (announces.parallelStream().anyMatch(anno -> anno.getId() == announce.getId())){
            throw new Exception("Announce already exists.");
        }
        announce.setId(this.increment);
        announces.add(announce);
    }

    public void edit(Announce announce) throws Exception {
        final Optional<Announce> value = this.announces
                .parallelStream()
                .filter(annoe -> announce.getId() == annoe.getId())
                .findFirst();
        if (value.isPresent()){
            announces.get
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
        //return null;
    }

    public List<Announce> view() {
        return this.announces;
    }

    public List<Announce> view(int qtdPerPage, int page) {
        return null;
    }
}
