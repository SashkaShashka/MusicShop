package com.company.musicshop.screen.instrument;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.Instrument;

@UiController("Instrument.browse")
@UiDescriptor("instrument-browse.xml")
@LookupComponent("instrumentsTable")
public class InstrumentBrowse extends StandardLookup<Instrument> {
}