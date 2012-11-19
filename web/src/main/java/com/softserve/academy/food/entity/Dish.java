package com.softserve.academy.food.entity;

import com.softserve.academy.food.model.DishModel;

import javax.persistence.*;

@Entity
@Table(name = "DISHES")
public class Dish {
    @Id
    @Column(name = "dish_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(name = "DISH_NAME", length = 50)
    private String name;

    @Column(name = "DISH_PRICE")
    private int price;

    @Column(name = "DISH_PHOTO", length = 50)
    private String photo;

    @Column(name = "DISH_DESCR", length = 50)
    private String descr;

    @Column(name = "DISH_AVAIL")
    private Character avail;

    @Column(name = "DISH_PREP_TIME")
    private int prepTime;

    @Column(name = "DISH_WEIGHT", length = 50)
    private int weight;

    public Dish() {
    }

    public Dish(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Dish(DishModel dish) {
        id = dish.getId();
        category = dish.getCategory().toEntity();
        name = dish.getName();
        price = dish.getPrice();
        photo = dish.getPhoto();
        descr = dish.getDescr();
        avail = dish.getAvail();
        prepTime = dish.getPrepTime();
        weight = dish.getWeight();

    }

    public DishModel toModel() {
        return new DishModel(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Character getAvail() {
        return avail;
    }

    public void setAvail(Character avail) {
        this.avail = avail;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Dish))
            return false;
        Dish other = (Dish) obj;
        if (avail == null) {
            if (other.avail != null)
                return false;
        } else if (!avail.equals(other.avail))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (descr == null) {
            if (other.descr != null)
                return false;
        } else if (!descr.equals(other.descr))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (photo == null) {
            if (other.photo != null)
                return false;
        } else if (!photo.equals(other.photo))
            return false;
        if (prepTime != other.prepTime)
            return false;
        if (price != other.price)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", category=" + category + ", name=" + name
                + ", price=" + price + ", photo=" + photo + ", descr=" + descr
                + ", avail=" + avail + ", prepTime=" + prepTime + ", weight="
                + weight + "]";
    }

}