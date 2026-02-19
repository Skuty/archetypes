package com.softwarearchetypes.planvsexecution.repaymentanalysis.modification;

public class LatePaymentCondition implements ScheduleModificationCondition {

    private final int minCount;

    public LatePaymentCondition(int minCount) {
        if (minCount <= 0) {
            throw new IllegalArgumentException("minCount must be > 0");
        }
        this.minCount = minCount;
    }

    public int minCount() {
        return minCount;
    }

    public static LatePaymentCondition atLeast(int count) {
        return new LatePaymentCondition(count);
    }
}
