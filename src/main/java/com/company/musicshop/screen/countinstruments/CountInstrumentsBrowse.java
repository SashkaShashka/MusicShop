package com.company.musicshop.screen.countinstruments;

import io.jmix.ui.screen.*;
import com.company.musicshop.entity.CountInstruments;

@UiController("CountInstruments.browse")
@UiDescriptor("count-instruments-browse.xml")
@LookupComponent("countInstrumentsesTable")
public class CountInstrumentsBrowse extends StandardLookup<CountInstruments> {
}