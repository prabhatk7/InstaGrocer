package com.instagrocer.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagrocer.inventory.business.ItemBean;
import com.instagrocer.inventory.service.InventoryService;

@RestController
public class InventoryController {
    @Autowired
    InventoryService InventoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemBean>> listItems(){
        List<ItemBean> items = InventoryService.listItems();
        if(items.size() > 0)
        return new ResponseEntity<List<ItemBean>> (items,HttpStatus.OK);
        else
        return new ResponseEntity<List<ItemBean>>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> addItem(@RequestBody ItemBean item){
        ItemBean resitem = InventoryService.addItem(item);
        return new ResponseEntity<String>("item added with id: "+resitem.getId(), HttpStatus.CREATED);
    }
}
