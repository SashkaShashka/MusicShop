package com.company.musicshop.screen.instrument;

import com.company.musicshop.entity.Order;
import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Instrument;

@UiController("Instrument.edit")
@UiDescriptor("instrument-edit.xml")
@EditedEntityContainer("instrumentDc")
public class InstrumentEdit extends StandardEditor<Instrument> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Instrument> event) {
        event.getEntity().setQuantity(100);
        event.getEntity().setWarranty(12);
    }
}