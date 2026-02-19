package com.softwarearchetypes.rules.discounting.offer.modifiers.functors.predicates;

import com.softwarearchetypes.quantity.Quantity;
import com.softwarearchetypes.quantity.money.Money;
import com.softwarearchetypes.rules.discounting.offer.OfferItem;
import com.softwarearchetypes.rules.predicates.RichLogicalPredicate;

import java.util.function.Predicate;

public class MoreExpensiveThanPredicate implements RichLogicalPredicate<OfferItem> {
    private final Money amount;

    public MoreExpensiveThanPredicate(Money amount) {
        this.amount = amount;
    }

    @Override
    public boolean test(OfferItem offerItem) {
        return offerItem.getBasePrice().isGreaterThanOrEqualTo(amount);
    }

    public Money getAmount() {
        return amount;
    }
}
