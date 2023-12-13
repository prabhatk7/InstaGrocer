package com.instagrocer.catalog.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.catalog.business.ItemBean;
import com.instagrocer.catalog.dao.CatalogDAOWrapper;

@Service
public class CatalogServiceImpl implements CatalogService {
    
    @Autowired
    CatalogDAOWrapper CatalogDAOWrapper;

    @Override
    public List<ItemBean> getCatalog(String itemtype){
        return CatalogDAOWrapper.getCatalog(itemtype);
    }

}
