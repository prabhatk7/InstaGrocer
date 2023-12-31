package com.instagrocer.inventory.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.inventory.business.ItemBean;
import com.instagrocer.inventory.dao.ItemDAOWrapper;

@Service
public class InventoryServiceImpl implements InventoryService {
    
    @Autowired
    ItemDAOWrapper ItemDAOWrapper;

    @Override
    public List<ItemBean> listItems(){
        return ItemDAOWrapper.listItems();
    }
    
    @Override
    public ItemBean addItem(ItemBean item){
        return ItemDAOWrapper.addItem(item);
    }

    @Override
    public ItemBean getItem(int itemid){
        return ItemDAOWrapper.getItem(itemid);
    }

    @Override
    public int deleteItem(int itemid){
        return ItemDAOWrapper.deleteItem(itemid);
    }

    @Override
    public int updateItem(int itemid, String name,String type,double price,int quantity){
        return ItemDAOWrapper.updateItem(itemid,name,type,price,quantity);
    }
}
