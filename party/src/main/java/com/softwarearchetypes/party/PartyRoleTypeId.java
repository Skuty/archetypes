package com.softwarearchetypes.party;

import java.util.UUID;

import static com.softwarearchetypes.common.Preconditions.checkArgument;
import static com.softwarearchetypes.common.StringUtils.isNotBlank;

record PartyRoleTypeId(String value) {

    public PartyRoleTypeId {
        checkArgument(isNotBlank(value), "PartyRoleTypeId cannot be blank");
    }

    public static PartyRoleTypeId random() {
        return new PartyRoleTypeId(UUID.randomUUID().toString());
    }

    public static PartyRoleTypeId of(String value) {
        return new PartyRoleTypeId(value);
    }

    public String asString() {
        return value;
    }
}
