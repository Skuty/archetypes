package com.softwarearchetypes.scoring.algebra.fuzzy;

/**
 * @param degree 0.0 .. 1.0
 */
public record FuzzyValue(double degree) {

    public FuzzyValue {
        if (degree < 0.0) degree = 0.0;
        if (degree > 1.0) degree = 1.0;
    }
}
