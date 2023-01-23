package com.technoavi.twiggy.controllers;


import com.technoavi.twiggy.model.Order;
import com.technoavi.twiggy.services.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//localhost:8082/order/palce-order
@RestController
@RequestMapping("/order")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @GetMapping("/msg")
    public String msg() {

        return "ready to place order!!";
    }

    @GetMapping("/msg1")
    public String msg1() {

        return "ready to place order1!!";
    }
    @GetMapping("/msg1")
    public String msg1() {

        return "ready to place order1!!";
    }
     //   uri
     //         method type  post/get/put/delete
     //       consumes = "JSON"
    //produces = "JSON"
    //@ResponseBody
    // @RequestMapping(value = "/place-order", method = RequestMethod.POST, consumes = "JSON", produces = "JSON")
    @PostMapping("/place-order")
    public String createOrder(@RequestBody Order order) {
        String result = foodOrderService.createOrder(order);
        return result;
    }
    //   @RequestMapping(value = "/place-order", method = RequestMethod.GET, produces = "JSON")
    @GetMapping("/getAll")
    public Map<Integer, Order> getAllOrder() {
        return foodOrderService.getAllOrder();
    }

    @GetMapping("/getorder/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return foodOrderService.getOrderById(id);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return foodOrderService.updateOrder(order);


    }

    @DeleteMapping("/delete/{oderId}")
    public String deleteOrder(@PathVariable("oderId") int id) {
        return foodOrderService.deleteOrder(id);
    }
}


