package com.instagrocer.catalog.dao;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.instagrocer.catalog.entity.ItemEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface CatalogDAO extends CrudRepository<ItemEntity, Integer> {
    //ItemEntity addItem(ItemEntity item);
    @Query(name = "getCatalog")
    List<ItemEntity> getCatalog();

    @Query(name = "getCatalogByType")
    List<ItemEntity> getCatalogByType(String itemtype);

} 
