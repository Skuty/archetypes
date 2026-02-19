package com.softwarearchetypes.party.commands;

import java.time.Instant;
import java.util.List;

import com.softwarearchetypes.party.OperatingScope;
import com.softwarearchetypes.party.PartyId;
import com.softwarearchetypes.party.Validity;

public record AddCapabilityCommand(
        PartyId partyId,
        String capabilityType,
        List<OperatingScope> scopes,
        Validity validity
) {
    public AddCapabilityCommand(PartyId partyId, String capabilityType, List<OperatingScope> scopes) {
        this(partyId, capabilityType, scopes, Validity.ALWAYS);
    }

    public AddCapabilityCommand(PartyId partyId, String capabilityType, List<OperatingScope> scopes, Instant validUntil) {
        this(partyId, capabilityType, scopes, Validity.until(validUntil));
    }
}
