package com.dimitri.services;

public interface IService<T,ID> {
    T create(T t);
    T update(T t);
    T read(ID id);
    void delete(ID id);
}
