package com.instagrocer.catalog.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagrocer.catalog.business.ItemBean;
import com.instagrocer.catalog.service.CatalogService;

@RestController
public class CatalogController {
    @Autowired
    CatalogService CatalogService;

    @RequestMapping(value = "catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemBean>> getCatalog(@RequestParam(name = "type", required = false) String itemtype){
        
        List<ItemBean> items = CatalogService.getCatalog(itemtype);
        if(items.size() > 0)
        return new ResponseEntity<List<ItemBean>> (items,HttpStatus.OK);
        else
        return new ResponseEntity<List<ItemBean>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("Hello World",HttpStatus.OK);
    }

}
