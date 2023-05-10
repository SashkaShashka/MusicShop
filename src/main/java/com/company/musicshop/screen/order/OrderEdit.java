package com.company.musicshop.screen.order;

import com.company.musicshop.entity.Cart;
import com.company.planner.Status;
import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Order;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@UiController("Order_.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Order> event) {
        event.getEntity().setStatus(Status.Accepted);
    }
}