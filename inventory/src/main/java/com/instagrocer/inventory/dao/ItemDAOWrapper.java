package com.instagrocer.inventory.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.inventory.business.ItemBean;
import com.instagrocer.inventory.entity.ItemEntity;

@Component
public class ItemDAOWrapper {
    @Autowired
    ItemDAO itemDao;

    private ItemEntity convertBeantoEntity(ItemBean bean){
        ItemEntity entity = new ItemEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    private ItemBean convertEntitytoBean(ItemEntity entity){
        ItemBean bean = new ItemBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<ItemBean> listItems(){
        List<ItemBean> items = new ArrayList<ItemBean>();
        List<ItemEntity> entities = itemDao.listItems();
        for(ItemEntity entity:entities){
            items.add(convertEntitytoBean(entity));
        }
        return items;
    }

    public ItemBean addItem(ItemBean bean){
        ItemEntity entity = convertBeantoEntity(bean);
        ItemEntity itementity = itemDao.save(entity);
        return convertEntitytoBean(itementity);
    }

    public ItemBean getItem(int itemid){
        ItemEntity entity = itemDao.getItem(itemid);
        return convertEntitytoBean(entity);
    }

    public int deleteItem(int itemid){
        int deleted = itemDao.deleteItem(itemid);
        return deleted;
    }

    public int updateItem(int itemid, String name,String type,double price,int quantity){
        Optional<ItemEntity> entity = itemDao.findById(itemid);
        if(!entity.isPresent())
        return 0;
        ItemEntity newentity = entity.get();
        if(name!=null)
        newentity.setName(name);
        if(type!=null)
        newentity.setType(type);;
        if(price!=-1.0)
        newentity.setPrice(price);
        if(quantity!=-1)
        newentity.setQuantity(quantity);
        itemDao.save(newentity);
        return 1;

    }
}
