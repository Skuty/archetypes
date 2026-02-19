package com.softwarearchetypes.ordering;

import java.util.List;
import java.util.Optional;

interface OrderRepository {

    void save(Order order);

    Optional<Order> findById(OrderId id);

    List<Order> findAll();
}
