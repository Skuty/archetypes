package com.softwarearchetypes.planvsexecution.repaymentanalysis.modification;

public class OnTimePaymentCondition implements ScheduleModificationCondition {

    private final int minCount;

    public OnTimePaymentCondition(int minCount) {
        if (minCount <= 0) {
            throw new IllegalArgumentException("minCount must be > 0");
        }
        this.minCount = minCount;
    }

    public int minCount() {
        return minCount;
    }

    public static OnTimePaymentCondition atLeast(int count) {
        return new OnTimePaymentCondition(count);
    }
}
