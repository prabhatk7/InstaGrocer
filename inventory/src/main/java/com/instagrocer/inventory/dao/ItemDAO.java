package com.instagrocer.inventory.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.instagrocer.inventory.entity.ItemEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ItemDAO extends CrudRepository<ItemEntity, Integer> {
    //ItemEntity addItem(ItemEntity item);
    @Query(name = "listItems")
    List<ItemEntity> listItems();

    @Query(name = "getItem")
    ItemEntity getItem(int itemid);

    @Modifying
    @Query(name = "deleteItem")
    int deleteItem(int itemid);
} 
