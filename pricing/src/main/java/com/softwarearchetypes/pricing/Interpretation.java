package com.softwarearchetypes.pricing;

/**
 * Semantic interpretation of calculator's result.
 *
 * The same mathematical function can have different meanings:
 * - TOTAL: total cost for given quantity/time
 * - UNIT: average price per single unit
 * - MARGINAL: price of n-th specific unit
 *
 * This enum captures the MEANING of the calculated Money value,
 * not just the numeric result.
 *
 * Example:
 * Step function: f(q) = base + ⌊q/step⌋ × increment
 * - Interpreted as TOTAL → "Total cost for q units"
 * - Interpreted as UNIT → "Average price per unit when buying q"
 * - Interpreted as MARGINAL → "Price of the q-th unit"
 */
public enum Interpretation {

    /**
     * Total Price - complete cost for entire quantity/time period.
     *
     * Examples:
     * - "Total cost for 15 items: 140 PLN"
     * - "Total invoice amount: 1500 EUR"
     * - "Complete project cost: 50000 PLN"
     *
     * Mathematical relation:
     * - Total(q) = Σ[i=1→q] Marginal(i)
     * - Total(q) = UnitAverage(q) × q
     *
     * Always applicable - works for 1D and multi-dimensional functions.
     */
    TOTAL,

    /**
     * Unit - average price per single unit.
     *
     * Examples:
     * - "10 PLN per kilogram"
     * - "150 PLN per hour"
     * - "Average price per item: 9.33 PLN"
     *
     * Mathematical relation:
     * - UnitAverage(q) = Total(q) / q
     *
     * Only applicable for 1-dimensional functions (quantity, time).
     * For multi-dimensional (e.g., GB × hours × region), unit price is ambiguous.
     */
    UNIT,

    /**
     * Marginal Price - price of n-th specific unit.
     *
     * Examples:
     * - "15th item costs 8 PLN" (bulk discount - later items cheaper)
     * - "11th hour costs 120 PLN" (premium - later hours more expensive)
     *
     * Mathematical relation (discrete):
     * - Marginal(n) = Total(n) - Total(n-1)
     *
     * Mathematical relation (continuous):
     * - Marginal(x) = dTotal/dx
     *
     * Only applicable for 1-dimensional functions.
     * Used for marginal analysis: "Should I buy one more unit?"
     */
    MARGINAL;

    /**
     * Human-readable description of this interpretation.
     */
    public String describe() {
        return switch (this) {
            case TOTAL -> "Total price for entire quantity/period";
            case UNIT -> "Average price per single unit";
            case MARGINAL -> "Price of n-th specific unit";
        };
    }
}