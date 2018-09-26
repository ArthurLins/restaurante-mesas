package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.bridge.TableDAO;
import me.arthurlins.restaurant.repositories.factories.TablePersistenceFactory;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TableService {

    private int MARGIN_PERSON = 1;
    private TableDAO dao;
    private ReserveService reserveService;


    public TableService() {
        try {
            this.dao = new TablePersistenceFactory().getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, int capacity) throws Exception {
        if (name.length() <= 0) {
            throw new InvalidParameterException();
        }
        if (capacity <= 0) {
            throw new InvalidParameterException();
        }
        Table table = new Table(name, capacity, false, 0);
        table = dao.insert(table);
        liberateTable(table);
        reserveService.newTableLiberate(table);
    }

    public void edit(Table table) throws Exception {
        dao.edit(table);
    }

    public void delete(Table table) {
        dao.remove(table);
    }

    public Table getBestTableTo(int qtdPersons) {
        if (qtdPersons <= 0) {
            throw new InvalidParameterException();
        }
        List<Table> tables = dao.getAllEmptyTables();
        if (tables.isEmpty()) {
            return null;
        }

        Optional<Table> optionalTableExact = tables.parallelStream()
                .filter(table -> table.getCapacity() == qtdPersons)
                .findFirst();

        if (optionalTableExact.isPresent()) {
            return optionalTableExact.get();
        }

        Optional<Table> optionalTableMargin = tables.parallelStream()
                .filter(table -> (Math.abs(table.getCapacity() - qtdPersons) <= MARGIN_PERSON) && qtdPersons <= table.getCapacity())
                .findFirst();
        return optionalTableMargin.orElse(null);

//        for (int i = 0; i < (MARGIN_PERSON + 1); i++) {
//            for (Table table : tables) {
//                if (table.getCapacity() == qtdPersons + i) {
//                    return table;
//                }
//            }
//        }
    }

    public void liberateById(long id) throws Exception {
        Table table = dao.getById(id);
        if (table == null) {
            throw new Exception("Table not exists");
        }
        liberateTable(table);
        reserveService.newTableLiberate(table);
    }

    public boolean hasEmptyTable() {
        return !dao.getAllEmptyTables().isEmpty();
    }

    public boolean hasTableForCapacity(int qtdPersons) {
        return dao.getAll().parallelStream().anyMatch((t) -> t.getCapacity() >= qtdPersons);
    }

    public List<Table> getAllEmptyTables() {
        return dao.getAllEmptyTables();
    }

    public List<Table> getAllTakenTables() {
        return dao.getAllTakenTables();
    }

    public List<Table> getAllTables() {
        return dao.getAll();
    }

    public void setReserveService(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    public void takeTable(Table table, int qtdPersons) {
        table.take(qtdPersons);
    }

    private void liberateTable(Table table) {
        table.liberate();
    }


}
