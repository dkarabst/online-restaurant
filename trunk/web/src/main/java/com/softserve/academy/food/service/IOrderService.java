package com.softserve.academy.food.service;

import java.util.Map;

public interface IOrderService {

    public void add(Map<Integer, Integer> dishIdsToQuantities);
    public void addAndroid(Map<Integer, Integer> dishIdsToQuantities,int id);
}
