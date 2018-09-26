package me.arthurlins.restaurant.services;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.bridge.TableDAO;
import me.arthurlins.restaurant.repositories.factories.TablePersistenceFactory;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TableService {

    private int MARGIN_PERSON = 2;
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
        dao.insert(new Table(name, capacity, false, 0));
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
        for (int i = 0; i < (MARGIN_PERSON + 1); i++) {
            for (Table table : tables) {
                if (table.getCapacity() == qtdPersons + i) {
                    return table;
                }
            }
        }
        return null;
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
