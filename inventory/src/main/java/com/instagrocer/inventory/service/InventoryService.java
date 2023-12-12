package com.instagrocer.inventory.service;

import java.util.List;

import com.instagrocer.inventory.business.ItemBean;

public interface InventoryService {
    List<ItemBean> listItems();
    ItemBean addItem(ItemBean item);
    ItemBean getItem(int itemid);
    int deleteItem(int itemid);
    int updateItem(int itemid, String name,String type,double price,int quantity);
}
