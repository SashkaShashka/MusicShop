package com.company.planner;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Status implements EnumClass<String> {
    Accepted("Accepted"),
    AwaitingPayment("AwaitingPayment"),
    Assembing("Assembing"),
    Assempled("Assempled"),
    TransferingToTheCourier("TransferingToTheCourier"),
    Delivered("Delivered"),
    AtThePickUpPoint("AtThePickUpPoint"),
    Cancelled("Cancelled");

    String id;

    Status(String id) {
        this.id=id;
    }

    public String getId(){
        return  id;
    }
    @Nullable
    public static Status fromId(String id) {
        for (Status dayOfWeek : Status.values()) {
            if (id.equals(dayOfWeek.getId())) return dayOfWeek;
        }
        return null;
    }
}
