package com.huaweiair.order.controller;

import com.huaweiair.order.model.FlightFlag;
import com.huaweiair.order.model.FlightOrder;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.servicecomb.provider.pojo.RpcSchema;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CsePojoCodegen", date = "2017-11-04T17:20:51.183+08:00")

@RpcSchema(schemaId = "order")
@RequestMapping(path = "/huaweiair/v1", produces = MediaType.APPLICATION_JSON)
public class OrderImpl {

    @Autowired
    private OrderDelegate orderDelegate;


    @RequestMapping(value = "/orders",
    		consumes = { "application/json" },
            produces = { "application/json" }, 
            method = RequestMethod.POST)
    public Boolean createOrders(@RequestBody FlightFlag order) {

        return orderDelegate.createOrders(order);
    }

    @RequestMapping(value = "/orders/{orderId}",
    		consumes = { "application/json" },
            produces = { "application/json" }, 
            method = RequestMethod.DELETE)
    public Boolean deleteOrder(@PathVariable(value="orderId", required=true) String orderId) {

        return orderDelegate.deleteOrder(orderId);
    }

    @RequestMapping(value = "/orders",
            produces = { "application/json" }, 
            method = RequestMethod.GET)
    public List<FlightOrder> getAllOrders(@RequestParam(value="userId", required=true) String userId) {

        return orderDelegate.getAllOrders(userId);
    }

    @RequestMapping(value = "/orders/{orderId}",
    		consumes = { "application/json" },
            produces = { "application/json" }, 
            method = RequestMethod.PUT)
    public Boolean modifyOrder(@PathVariable(value="orderId", required=true) String orderId, @RequestParam(value="action", required=true) int action) {

        return orderDelegate.modifyOrder(orderId, action);
    }

}
