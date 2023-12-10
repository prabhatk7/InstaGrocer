package com.instagrocer.inventory.service;

import java.util.List;

import com.instagrocer.inventory.business.ItemBean;

public interface InventoryService {
    List<ItemBean> listItems();
    ItemBean addItem(ItemBean item);
}
