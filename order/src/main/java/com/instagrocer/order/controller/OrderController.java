package com.instagrocer.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagrocer.order.business.OrderBean;
import com.instagrocer.order.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "order/{orderid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderBean> getOrderById(@PathVariable("orderid") int orderid){
        OrderBean item = orderService.getOrderById(orderid);
        if(item != null)
        return new ResponseEntity<OrderBean> (item,HttpStatus.OK);
        else
        return new ResponseEntity<OrderBean>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "order", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> placeOrder(@RequestBody OrderBean order){
        String result = orderService.placeOrder(order);
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("Hello from Order microservice!",HttpStatus.OK);
    }
}
