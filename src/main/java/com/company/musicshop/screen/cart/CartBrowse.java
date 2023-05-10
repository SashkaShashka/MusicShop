package com.company.musicshop.screen.cart;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Cart;

@UiController("Cart.browse")
@UiDescriptor("cart-browse.xml")
@LookupComponent("cartsTable")
public class CartBrowse extends StandardLookup<Cart> {
}