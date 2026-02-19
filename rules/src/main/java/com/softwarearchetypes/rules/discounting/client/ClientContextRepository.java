package com.softwarearchetypes.rules.discounting.client;

import java.util.UUID;

public interface ClientContextRepository {
    ClientContext loadClientContext(UUID clientId);
}
