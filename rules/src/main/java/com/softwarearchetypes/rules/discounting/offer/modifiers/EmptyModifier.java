package com.softwarearchetypes.rules.discounting.offer.modifiers;

import com.softwarearchetypes.rules.discounting.OfferItemModifier;
import com.softwarearchetypes.rules.discounting.offer.OfferItem;

public class EmptyModifier implements OfferItemModifier {
    @Override
    public OfferItem modify(OfferItem item) {
        return item;
    }
}
