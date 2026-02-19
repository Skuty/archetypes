package com.softwarearchetypes.planvsexecution.badimplementation.deliveryscheduling;

import java.util.HashMap;
import java.util.Map;

public class WarehouseRepository {
    private final Map<String, Warehouse> storageByRegion = new HashMap<>();

    public void save(Warehouse warehouse) {
        storageByRegion.put(warehouse.getLocation(), warehouse);
    }

    public Warehouse findByRegion(String region) {
        return storageByRegion.get(region);
    }
}
