package com.softwarearchetypes.ordering.commands;

import com.softwarearchetypes.ordering.OrderId;

public record ConfirmOrderCommand(OrderId orderId) {}
