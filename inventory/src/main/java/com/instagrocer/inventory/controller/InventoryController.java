package com.instagrocer.inventory.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.instagrocer.inventory.business.ItemBean;
import com.instagrocer.inventory.service.InventoryService;

@RestController
public class InventoryController {
    @Autowired
    InventoryService InventoryService;

    @RequestMapping(value = "items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemBean>> listItems(){
        List<ItemBean> items = InventoryService.listItems();
        if(items.size() > 0)
        return new ResponseEntity<List<ItemBean>> (items,HttpStatus.OK);
        else
        return new ResponseEntity<List<ItemBean>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "item", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemBean> getItem(@RequestParam(name = "itemid", required = true) int itemid){
        ItemBean item = InventoryService.getItem(itemid);
        if(item != null)
        return new ResponseEntity<ItemBean> (item,HttpStatus.OK);
        else
        return new ResponseEntity<ItemBean>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "item/{itemid}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> deleteItem(@PathVariable("itemid") int itemid){
        int item = InventoryService.deleteItem(itemid);
        if(item == 1)
        return new ResponseEntity<String> ("deleted item with id: "+itemid,HttpStatus.OK);
        else
        return new ResponseEntity<String>("Item with id: "+itemid+" not found!", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "item/{itemid}", method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable("itemid") int itemid, @RequestBody ObjectNode newitem ){
        
        String name=null,type=null;
        if(newitem.get("name")!=null)
        name = newitem.get("name").asText();
        if(newitem.get("type")!=null)
        type = newitem.get("type").asText();

        double price=-1.0;
        if(newitem.get("price")!=null)
        price = newitem.get("price").asDouble();

        int quantity = -1;
        if(newitem.get("quantity")!=null)
        quantity = newitem.get("quantity").asInt();

        System.out.println(name+" "+type);
        System.out.println(price+" "+quantity);
        
        int item = InventoryService.updateItem(itemid,name,type,price,quantity);
        if(item == 1)
        return new ResponseEntity<String> ("updated item with id: "+itemid,HttpStatus.OK);
        else
        return new ResponseEntity<String>("Item with id: "+itemid+" not found!", HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "item", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> addItem(@RequestBody ItemBean item){
        ItemBean resitem = InventoryService.addItem(item);
        return new ResponseEntity<String>("item added with id: "+resitem.getId(), HttpStatus.CREATED);
    }
}
