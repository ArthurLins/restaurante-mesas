package me.arthurlins.restaurant.repositories.bridge;

import java.util.List;

/**
 * Created by Arthur on 24/09/2018.
 */
public interface DefaultCRUD<T> {
    void insert(T t);
    void edit(T t);
    void remove(T t);
    T getById(int id);
    List<T> view();
    List<T> view(int qtdPerPage, int page);
}
