package com.softserve.academy.food.entity;

import com.softserve.academy.food.model.ContentModel;

import javax.persistence.*;

@Entity
@Table(name = "ORDERSPEC")
public class OrderContents {
    @Id
    @Column(name = "ospec_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderInfo orderInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dish dish;

    @Column(name = "OSPEC_QUANTITY")
    private Integer quantity;

    public OrderContents() {
    }

    public OrderContents(Dish dish, int quantity, OrderInfo orderInfo) {
        this.dish = dish;
        this.quantity = quantity;
        this.orderInfo = orderInfo;
    }

    public OrderContents(ContentModel content) {
        id = content.getId();
        orderInfo = content.getOrderInfo().toEntity();
        dish = content.getDish().toEntity();
        quantity = content.getQuantity();
    }

    public ContentModel toModel() {
        return new ContentModel(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderContents other = (OrderContents) obj;
        if (dish == null) {
            if (other.dish != null)
                return false;
        } else if (!dish.equals(other.dish))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (orderInfo == null) {
            if (other.orderInfo != null)
                return false;
        } else if (!orderInfo.equals(other.orderInfo))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderContents [id=" + id + ", orderInfo=" + orderInfo
                + ", dish=" + dish + ", quantity=" + quantity + "]";
    }


} 
