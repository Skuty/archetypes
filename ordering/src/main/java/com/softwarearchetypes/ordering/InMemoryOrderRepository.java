package com.softwarearchetypes.ordering;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class InMemoryOrderRepository implements OrderRepository {

    private final Map<OrderId, Order> storage = new HashMap<>();

    @Override
    public void save(Order order) {
        storage.put(order.id(), order);
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Order> findAll() {
        return List.copyOf(storage.values());
    }
}
