package com.softwarearchetypes.planvsexecution.badimplementation.deliveryscheduling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverAvailabilityRepository {
    private final List<DriverAvailability> storage = new ArrayList<>();

    public void save(DriverAvailability availability) {
        storage.add(availability);
    }

    public List<DriverAvailability> findAvailableDriversOn(LocalDate date) {
        return storage.stream()
                .filter(d -> d.getDate().equals(date) && d.isAvailable())
                .collect(Collectors.toList());
    }
}
