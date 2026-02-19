package com.softwarearchetypes.planvsexecution.repaymentanalysis;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TestInstants {

    public static Instant instantUTC(int year, int month, int day, int hour, int minute) {
        return LocalDateTime.of(year, month, day, hour, minute).toInstant(ZoneOffset.UTC);
    }
}
