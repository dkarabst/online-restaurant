package com.softserve.academy.food.model;

import com.softserve.academy.food.entity.OrderContents;

public class ContentModel {
    private int id;
    private OrderModel orderInfo;
    private DishModel dish;
    private Integer quantity;

    public ContentModel() {
    }

    public ContentModel(OrderContents content) {
        id = content.getId();
        orderInfo = content.getOrderInfo().toModel();
        dish = content.getDish().toModel();
        quantity = content.getQuantity();
    }

    public OrderContents toEntity() {
        return new OrderContents(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderModel getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderModel orderInfo) {
        this.orderInfo = orderInfo;
    }

    public DishModel getDish() {
        return dish;
    }

    public void setDish(DishModel dish) {
        this.dish = dish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Model - " + id + " order - " + orderInfo + " Dish - " + dish
                + " quantity - " + quantity;
    }

}
