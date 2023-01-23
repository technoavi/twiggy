package com.technoavi.twiggy.services;

import com.technoavi.twiggy.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

@Service
public class FoodOrderService {
    //List< Order> listOfOrders= new ArrayList();
    Map<Integer, Order> listOfOrders = new HashMap();
    Random r = new Random();

    public String createOrder(Order order) {

        Order newOrder = new Order();
        newOrder.setOrderId(r.nextInt(900) + 100);
        System.out.println(newOrder.getOrderId());
        newOrder.setItemName(order.getItemName());
        newOrder.setPrice(order.getPrice());
        newOrder.setTime(order.getTime());
        newOrder.setRestaurantName(order.getRestaurantName());
        newOrder.setDeliveryAddress(order.getDeliveryAddress());
        //    listOfOrders.add(newOrder);
        listOfOrders.put(newOrder.getOrderId(), newOrder);


        return " Your order of :" + newOrder.getItemName() + " has been placed and order Id is :" + newOrder.getOrderId();
    }

    public Map<Integer, Order> getAllOrder() {


        return listOfOrders;
    }

    public Order getOrderById( int id) {
        for (int i = 0; i < listOfOrders.size(); i++) {
            if (listOfOrders.get(i).getOrderId() == (id)) {
                return listOfOrders.get(i);
            }

        }
        return null;
    }

    public Order updateOrder( Order order) {

        int id = 0;
//        for(int i=0; i<listOfOrders.size();i++) {
//            if (listOfOrders.get(i).getOrderId() == (order.getOrderId())) {
//                id = order.getOrderId();
//                break;
//            }
//        }
        Iterator hmIterator = listOfOrders.entrySet().iterator();


        while (hmIterator.hasNext()) {
            if (listOfOrders.containsKey(order.getOrderId())) {
                id = order.getOrderId();
                break;

            }

        }

        //updated
        Order upOrder = new Order();
        upOrder.setOrderId(id);
        upOrder.setItemName(order.getItemName());
        upOrder.setPrice(order.getPrice());
        upOrder.setTime(order.getTime());
        upOrder.setRestaurantName(order.getRestaurantName());
        upOrder.setDeliveryAddress(order.getDeliveryAddress());
        listOfOrders.put(upOrder.getOrderId(), upOrder);
        //  listOfOrders.add(id,upOrder);
        return upOrder;

    }

    public String deleteOrder(int id) {
        // listOfOrders.remove(id);
        //  listOfOrders.removeIf(order-> order.getOrderId()==(id));
        listOfOrders.remove(id);
        return "Oder id" + id + " id cancelled!!";
    }
}
