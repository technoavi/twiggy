package com.technoavi.twiggy.model;

import org.springframework.stereotype.Component;

import java.util.Objects;


public class Order {
    private int orderId;
    private String itemName;
    private String restaurantName;
    private float  price;
    private String time;
    private String deliveryAddress;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Float.compare(order.price, price) == 0 && Objects.equals(itemName, order.itemName) && Objects.equals(restaurantName, order.restaurantName) && Objects.equals(time, order.time) && Objects.equals(deliveryAddress, order.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemName, restaurantName, price, time, deliveryAddress);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemName='" + itemName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", price=" + price +
                ", time='" + time + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}
