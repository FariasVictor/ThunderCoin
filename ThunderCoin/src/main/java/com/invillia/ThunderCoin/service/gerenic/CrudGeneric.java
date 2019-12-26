package com.invillia.ThunderCoin.service.gerenic;

import java.util.List;

public interface CrudGeneric<T, Long> {

    Long save(T entity);
    Long update(T entity);
    void delete(Long id);
    List<T> findAll();
    T findById(Long id);

}
