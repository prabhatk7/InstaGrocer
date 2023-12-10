package com.instagrocer.inventory.dao;

import java.util.ArrayList;
import java.util.List;

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
}
