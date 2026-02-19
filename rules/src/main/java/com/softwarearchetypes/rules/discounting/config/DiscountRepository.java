package com.softwarearchetypes.rules.discounting.config;

import com.softwarearchetypes.rules.discounting.OfferItemModifier;
import com.softwarearchetypes.rules.discounting.client.ClientContext;
import com.softwarearchetypes.rules.discounting.config.reflection.Discount;
import com.softwarearchetypes.rules.discounting.config.reflection.DiscountParam;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public interface DiscountRepository {
    List<Discount> findAllDiscounts();

    List<DiscountParam> findParamsByDiscountId(UUID id);

    UUID insert(Discount discount);

    void insertParam(DiscountParam discountParam);
}
