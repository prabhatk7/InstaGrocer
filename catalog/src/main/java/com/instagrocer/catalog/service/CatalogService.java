package com.instagrocer.catalog.service;

import java.util.List;

import com.instagrocer.catalog.business.ItemBean;

public interface CatalogService {
    List<ItemBean> getCatalog(String itemtype);
}
