package com.softserve.academy.food.entity;


import javax.persistence.*;

@Entity
@Table(name = "ORDERSPEC")
public class OrderDetail {
    @Id
    @Column(name = "ospec_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order orderInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dish dish;

    @Column(name = "OSPEC_QUANTITY")
    private Integer quantity;

    public OrderDetail() {
    }

    public OrderDetail(Dish dish, int quantity, Order orderInfo) {
        this.dish = dish;
        this.quantity = quantity;
        this.orderInfo = orderInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Order orderInfo) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dish == null) ? 0 : dish.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((orderInfo == null) ? 0 : orderInfo.hashCode());
        result = prime * result
                + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderDetail other = (OrderDetail) obj;
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
