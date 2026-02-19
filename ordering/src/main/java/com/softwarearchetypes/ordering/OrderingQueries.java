package com.softwarearchetypes.ordering;

import java.util.List;
import java.util.Optional;

public class OrderingQueries {

    private final OrderRepository orderRepository;

    OrderingQueries(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<OrderView> findById(OrderId id) {
        return orderRepository.findById(id).map(OrderView::from);
    }

    public List<OrderView> findAll() {
        return orderRepository.findAll().stream().map(OrderView::from).toList();
    }
}
