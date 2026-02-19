package com.softwarearchetypes.planvsexecution.badimplementation.deliveryscheduling;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private final Map<Long, Customer> storage = new HashMap<>();

    public void save(Customer customer) {
        storage.put(customer.getId(), customer);
    }

    public Customer findById(Long id) {
        return storage.get(id);
    }
}
