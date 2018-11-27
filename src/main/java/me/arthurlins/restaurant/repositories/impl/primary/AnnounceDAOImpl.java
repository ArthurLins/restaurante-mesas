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

    @Override
    public boolean isValidCode(Announce announce) {
        return announces.parallelStream().anyMatch(announce1 -> announce1.getCode().equals(announce.getCode()));
    }

    @Override
    public Announce get(String announceCode) throws Exception {
        Optional<Announce> ann = announces
                .parallelStream()
                .filter(announce1 -> announce1.getClientQueue().getRandomCode().equals(announceCode))
                .findFirst();
        if (ann.isPresent()) {
            return ann.get();
        }
        throw new Exception("Not have code");
    }

    @Override
    public void createCode(Announce announce) {
        announces.add(new Announce(increment.getAndIncrement(), announce.getClientQueue(), announce.getTable()));
    }

    @Override
    public void attendAnnounce(Announce announce) {
        announces.removeIf(announce1 -> announce1.getId() == announce.getId());
    }


}
