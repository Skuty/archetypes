package com.softwarearchetypes.pricing;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.Clock.fixed;

class ClockFixture {

    static Clock someFixedClock() {
        Instant time = LocalDateTime.of(2025, 1, 15, 12, 50).atZone(ZoneId.systemDefault()).toInstant();
        return fixedClock(time);
    }

    static Clock fixedClock(Instant time) {
        return fixed(time, ZoneId.systemDefault());
    }

}
