package com.dimitri.repository;

public interface IRepository<T, ID> {
    T create(T t);
    T update(T t);
    T read(ID id);
    void delete(ID id);
}
