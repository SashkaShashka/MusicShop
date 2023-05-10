package com.company.musicshop.screen.order;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Order;

@UiController("Order_.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {
}