package com.softserve.academy.food.entity;

import com.softserve.academy.food.model.ContentModel;
import com.softserve.academy.food.model.OrderModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERINFO")
public class OrderInfo {
    @Id
    @Column(name = "oinfo_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(name = "OINFO_DATE")
    private Date date;

    @Column(name = "OINFO_STATUS")
    private Character status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderInfo", cascade = CascadeType.ALL)
    private List<OrderContents> spec = new ArrayList<OrderContents>();

    public OrderInfo() {
    }

    public OrderInfo(OrderModel order) {
        id = order.getId();
        user = order.getUser().toEntity();
        date = order.getDate();
        status = order.getStatus();

        List<OrderContents> spec = new ArrayList<OrderContents>();
        for (ContentModel content : order.getSpec()) {
            spec.add(content.toEntity());
        }
        this.spec = spec;
    }

    public OrderModel toModel() {
        return new OrderModel(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public List<OrderContents> getSpec() {
        return spec;
    }

    public void setSpec(List<OrderContents> spec) {
        this.spec = spec;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        OrderInfo other = (OrderInfo) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderInfo [id=" + id + ", user=" + user + ", date=" + date
                + ", status=" + status + ", spec=" + spec + "]";
    }


} 
