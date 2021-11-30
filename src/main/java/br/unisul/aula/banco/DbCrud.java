package br.unisul.aula.banco;

import java.util.List;

public interface DbCrud<T> {
    void insert(T t);
    void remove(Long id);
    void update(T t);
    List<T> findAll();
    T findById(Long id);
}
