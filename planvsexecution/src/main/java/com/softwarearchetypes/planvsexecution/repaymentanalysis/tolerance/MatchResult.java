package com.softwarearchetypes.planvsexecution.repaymentanalysis.tolerance;

public record MatchResult(boolean matched, String reason) {

    public static MatchResult matched(String reason) {
        return new MatchResult(true, reason);
    }

    public static MatchResult notMatched(String reason) {
        return new MatchResult(false, reason);
    }
}
