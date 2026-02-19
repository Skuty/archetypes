package com.softwarearchetypes.party;

import java.util.List;
import java.util.Optional;

interface CapabilitiesRepository {

    void save(Capability capability);

    void remove(CapabilityId id);

    Optional<Capability> findById(CapabilityId id);

    List<Capability> findByPartyId(PartyId partyId);

    List<Capability> findByType(CapabilityType type);

    List<Capability> findAll();
}
