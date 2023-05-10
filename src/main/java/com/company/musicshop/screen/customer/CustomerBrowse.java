package com.company.musicshop.screen.customer;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Customer;

@UiController("Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
public class CustomerBrowse extends StandardLookup<Customer> {
}