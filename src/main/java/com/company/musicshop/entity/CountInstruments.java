package com.company.musicshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "COUNT_INSTRUMENTS", indexes = {
        @Index(name = "IDX_COUNT_INSTRUMENTS_INSTRUMENT", columnList = "INSTRUMENT_ID")
})
@Entity
public class CountInstruments {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Positive
    @Column(name = "COUNT")
    private Integer count;

    @JoinTable(name = "ORDER_COUNT_INSTRUMENTS_LINK",
            joinColumns = @JoinColumn(name = "COUNT_INSTRUMENTS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Order> orders;

    @NotNull
    @JoinColumn(name = "INSTRUMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Instrument instrument;

    @Positive
    @Column(name = "SUM")
    private Integer sum;

    @JoinTable(name = "CART_COUNT_INSTRUMENTS_LINK",
            joinColumns = @JoinColumn(name = "COUNT_INSTRUMENTS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CART_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Cart> carts;

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Integer getSum (){
        if (getInstrument() == null)
        return 0;
        return getInstrument().getPrice()*getCount();
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @InstanceName
    @DependsOnProperties({"count", "instrument"})
    public String getInstanceName() {
        return String.format("%s %s", count, instrument);
    }
}