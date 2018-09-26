package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.bridge.TableDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
        if (table.getId() != -1) {
            if (tables.parallelStream().anyMatch(ano -> ano.getId() == finalTable.getId())) {
                throw new Exception("Table already exists.");
            }
        }
        table = new Table(increment.getAndIncrement(), table.getName(), table.getCapacity(), table.isTacked(),
                table.getPersonsInTable());
        tables.add(table);

    }

    public void edit(Table table) throws Exception {
        Table anon;
        for (int i = 0; i < tables.size(); i++){
            anon = tables.get(i);
            if (anon.getId() == table.getId()){
                table = new Table(table.getId(), table.getName(), table.getCapacity(), table.isTacked(), table.getPersonsInTable());
                tables.set(i, table);
                return;
            }
        }
        throw new Exception("Table not exists");
    }

    public void remove(Table table) {
        this.tables.removeIf(ano -> table.getId() == ano.getId());
    }

    public Table getById(long id) {
        final Optional<Table> value = this.tables
                .parallelStream()
                .filter(table -> table.getId() == id)
                .findFirst();
        return value.orElse(null);
    }

    @Override
    public List<Table> getAllEmptyTables() {
        return tables.parallelStream().filter(table -> !table.isTacked()).collect(Collectors.toList());
    }

    @Override
    public List<Table> getAllTakenTables() {
        return tables.parallelStream().filter(Table::isTacked).collect(Collectors.toList());
    }

    @Override
    public List<Table> getAll() {
        return tables;
    }


    public List<Table> view(int qtdPerPage, int page) {
        //Todo..
        return null;
    }
}
