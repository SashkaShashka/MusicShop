package com.company.musicshop.screen.customer;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Customer;

@UiController("Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {
}