package me.arthurlins.restaurant.repositories.bridge;

import me.arthurlins.restaurant.model.Table;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface TableDAO {
    void insert(Table Table) throws Exception;
    void edit(Table Table) throws Exception;
    void remove(Table Table);
    Table getById(int id);
    List<Table> view();
    List<Table> view(int qtdPerPage, int page);
}
