package com.instagrocer.catalog.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instagrocer.catalog.business.ItemBean;
import com.instagrocer.catalog.entity.ItemEntity;

@Component
public class CatalogDAOWrapper {
    @Autowired
    CatalogDAO catalogDao;

    // private ItemEntity convertBeantoEntity(ItemBean bean){
    //     ItemEntity entity = new ItemEntity();
    //     BeanUtils.copyProperties(bean, entity);
    //     return entity;
    // }

    private ItemBean convertEntitytoBean(ItemEntity entity){
        ItemBean bean = new ItemBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<ItemBean> getCatalog(String type){
        List<ItemBean> items = new ArrayList<ItemBean>();
        List<ItemEntity> entities;
        if(type==null)
        entities = catalogDao.getCatalog();
        else
        entities = catalogDao.getCatalogByType(type);
        for(ItemEntity entity:entities){
            items.add(convertEntitytoBean(entity));
        }
        return items;
    }
}
