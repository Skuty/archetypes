package com.softwarearchetypes.planvsexecution.repaymentanalysis.modification;

import com.softwarearchetypes.planvsexecution.repaymentanalysis.PaymentSchedule;
import com.softwarearchetypes.planvsexecution.repaymentanalysis.delta.DeltaResult;

@FunctionalInterface
public interface PaymentScheduleModifier {

    PaymentSchedule modify(PaymentSchedule current, DeltaResult deltaResult);

    default PaymentScheduleModifier andThen(PaymentScheduleModifier next) {
        return (schedule, delta) -> next.modify(this.modify(schedule, delta), delta);
    }
}
