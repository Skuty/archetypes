package com.softwarearchetypes.ordering;

class OrderFactory {

    private final OrderServices services;

    OrderFactory(OrderServices services) {
        this.services = services;
    }

    Order.Builder newOrder(OrderId id, OrderParties parties) {
        return Order.builder(id, parties, services);
    }
}
