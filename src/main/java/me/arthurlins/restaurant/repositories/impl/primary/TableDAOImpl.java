package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.bridge.TableDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TableDAOImpl implements TableDAO {

    private AtomicLong increment;
    private List<Table> tables;

    public TableDAOImpl() {
        this.tables = new ArrayList<>();
        this.increment = new AtomicLong(0);
    }

    public void insert(Table table) throws Exception {
        final Table finalTable = table;
        if (tables.parallelStream().anyMatch(ano -> ano.getId() == finalTable.getId())){
            throw new Exception("Table already exists.");
        }
        table = new Table(increment.getAndIncrement(), table.getName(), table.getCapacity(), table.isTaked());
        tables.add(table);
    }

    public void edit(Table table) throws Exception {
        Table anon;
        for (int i = 0; i < tables.size(); i++){
            anon = tables.get(i);
            if (anon.getId() == table.getId()){
                table = new Table(increment.getAndIncrement(), table.getName(), table.getCapacity(), table.isTaked());
                tables.set(i, table);
                return;
            }
        }
        throw new Exception("Table not exists");
    }

    public void remove(Table table) {
        this.tables.removeIf(ano -> table.getId() == ano.getId());
    }

    public Table getById(int id) {
        final Optional<Table> value = this.tables
                .parallelStream()
                .filter(table -> table.getId() == id)
                .findFirst();
        return value.orElse(null);
    }

    public List<Table> view() {
        return this.tables;
    }

    public List<Table> view(int qtdPerPage, int page) {
        //Todo..
        return null;
    }
}
