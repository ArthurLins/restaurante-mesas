package me.arthurlins.restaurant.repositories.impl.primary;

import me.arthurlins.restaurant.model.Table;
import me.arthurlins.restaurant.repositories.bridge.TableDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public class TableDAOImpl implements TableDAO {

    private List<Table> tables;

    public TableDAOImpl() {
        this.tables = new ArrayList<Table>();
    }

    public void insert(Table table) {

    }

    public void edit(Table table) {

    }

    public void remove(Table table) {

    }

    public Table getById(int id) {
        return null;
    }

    public List<Table> view() {
        return null;
    }

    public List<Table> view(int qtdPerPage, int page) {
        return null;
    }
}
