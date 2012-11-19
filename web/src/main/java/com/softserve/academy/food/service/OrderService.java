package com.softserve.academy.food.service;

import java.util.Map;

public interface OrderService {

    public void add(Map<Integer, Integer> dishIdsToQuantities);
}
