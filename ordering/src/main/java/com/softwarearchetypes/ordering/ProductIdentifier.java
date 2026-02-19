package com.softwarearchetypes.ordering;

public record ProductIdentifier(String value) {

    public static ProductIdentifier of(String value) {
        return new ProductIdentifier(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
