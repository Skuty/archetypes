package com.softwarearchetypes.pricing;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Version of a SimpleComponent - represents calculator configuration valid during a time period.
 *
 * Contains:
 * - Calculator: the pricing formula (fixed, step function, composite, etc.)
 * - Parameter mappings: how to transform component parameters to calculator parameters
 * - Validity: time period when this version is active
 * - DefinedAt: when this version was created (for tiebreaking)
 *
 * Example:
 * - Version 1: Fixed 100 PLN, valid from 2024-01-01 forever
 * - Version 2: Fixed 80 PLN (discount), valid from 2024-02-01 to 2024-03-01
 * - After 2024-03-01: automatically reverts to Version 1
 */
record SimpleComponentVersion(
    Calculator calculator,
    Map<String, String> parameterMappings,
    Validity validity,
    LocalDateTime definedAt
) implements ComponentVersion {

    public SimpleComponentVersion {
        parameterMappings = Map.copyOf(parameterMappings);
        Objects.requireNonNull(definedAt, "definedAt cannot be null");
    }

    /**
     * Create version with clock - definedAt will be set to now(clock).
     */
    public static SimpleComponentVersion of(
            Calculator calculator,
            Map<String, String> parameterMappings,
            Validity validity,
            Clock clock
    ) {
        return new SimpleComponentVersion(calculator, parameterMappings, validity, LocalDateTime.now(clock));
    }

    /**
     * Create version without parameter mappings (direct pass-through).
     */
    public static SimpleComponentVersion of(Calculator calculator, Validity validity, Clock clock) {
        return new SimpleComponentVersion(calculator, Map.of(), validity, LocalDateTime.now(clock));
    }
}