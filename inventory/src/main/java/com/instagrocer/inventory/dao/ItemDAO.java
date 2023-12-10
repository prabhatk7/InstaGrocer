package com.instagrocer.inventory.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.instagrocer.inventory.entity.ItemEntity;

import jakarta.transaction.Transactional;

@Transactional
public interface ItemDAO extends CrudRepository<ItemEntity, Integer> {
    //ItemEntity addItem(ItemEntity item);
    @Query(name = "listItems")
    List<ItemEntity> listItems();
} 
