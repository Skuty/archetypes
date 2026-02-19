package com.softwarearchetypes.pricing;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Version of a CompositeComponent - represents composition of children valid during a time period.
 *
 * Contains:
 * - Children: list of child components that make up this composite
 * - Dependencies: parameter enrichment rules (which child provides values for others)
 * - Validity: time period when this composition is active
 * - DefinedAt: when this version was created (for tiebreaking)
 *
 * Example - eMobility pricing changing over time:
 * - Version 1 (Jan-Apr): children = [EnergyCharge, ParkingFee], valid [2024-01-01, 2024-05-01)
 * - Version 2 (May+): children = [EnergyCharge, ParkingFee, SeasonalSurcharge], valid [2024-05-01, ∞)
 *
 * Each child component maintains its own version history independently.
 */
record CompositeComponentVersion(
    List<Component> children,
    Map<ComponentId, Map<String, ParameterValue>> dependencies,
    Validity validity,
    LocalDateTime definedAt
) implements ComponentVersion {

    public CompositeComponentVersion {
        children = List.copyOf(children);
        dependencies = Map.copyOf(dependencies.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> Map.copyOf(e.getValue())
            )));
        Objects.requireNonNull(definedAt, "definedAt cannot be null");
    }

    /**
     * Create version with clock - definedAt will be set to now(clock).
     */
    public static CompositeComponentVersion of(
            List<Component> children,
            Map<ComponentId, Map<String, ParameterValue>> dependencies,
            Validity validity,
            Clock clock
    ) {
        return new CompositeComponentVersion(children, dependencies, validity, LocalDateTime.now(clock));
    }

    /**
     * Create version without dependencies (children are independent).
     */
    public static CompositeComponentVersion of(List<Component> children, Validity validity, Clock clock) {
        return new CompositeComponentVersion(children, Map.of(), validity, LocalDateTime.now(clock));
    }

    /**
     * Create version without dependencies (children are independent).
     */
    public static CompositeComponentVersion of(Validity validity, Clock clock, Component... children) {
        return new CompositeComponentVersion(List.of(children), Map.of(), validity, LocalDateTime.now(clock));
    }
}