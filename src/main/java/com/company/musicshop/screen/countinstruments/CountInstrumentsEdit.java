package com.company.musicshop.screen.countinstruments;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.CountInstruments;

@UiController("CountInstruments.edit")
@UiDescriptor("count-instruments-edit.xml")
@EditedEntityContainer("countInstrumentsDc")
public class CountInstrumentsEdit extends StandardEditor<CountInstruments> {


    @Subscribe
    public void onInitEntity(InitEntityEvent<CountInstruments> event) {
        event.getEntity().setSum(0);
        event.getEntity().setCount(1);
    }
}