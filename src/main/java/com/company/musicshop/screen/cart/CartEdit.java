package com.company.musicshop.screen.cart;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Cart;

@UiController("Cart.edit")
@UiDescriptor("cart-edit.xml")
@EditedEntityContainer("cartDc")
public class CartEdit extends StandardEditor<Cart> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Cart> event) {
        event.getEntity().setCartSum(0);
    }
}