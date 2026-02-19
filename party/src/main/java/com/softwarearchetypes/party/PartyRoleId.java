package com.softwarearchetypes.party;

import java.util.UUID;

import static com.softwarearchetypes.common.Preconditions.checkArgument;
import static com.softwarearchetypes.common.StringUtils.isNotBlank;

public record PartyRoleId(String value) {

    public PartyRoleId {
        checkArgument(isNotBlank(value), "PartyRoleId cannot be blank");
    }

    public static PartyRoleId random() {
        return new PartyRoleId(UUID.randomUUID().toString());
    }

    public static PartyRoleId of(String value) {
        return new PartyRoleId(value);
    }

    public String asString() {
        return value;
    }
}
