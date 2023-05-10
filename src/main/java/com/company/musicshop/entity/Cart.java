package com.company.musicshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CART")
@Entity
public class Cart {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinTable(name = "CART_COUNT_INSTRUMENTS_LINK",
            joinColumns = @JoinColumn(name = "CART_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COUNT_INSTRUMENTS_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<CountInstruments> instrumentCart;

    @Column(name = "CARTSUM", nullable = false)
    private Integer cartSum;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cart")
    private Customer customer;

    public List<CountInstruments> getInstrumentCart() {
        return instrumentCart;
    }

    public void setInstrumentCart(List<CountInstruments> instrumentCart) {
        this.instrumentCart = instrumentCart;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCartSum(){
        Integer orderSum = 0;
        List<CountInstruments> instruments = getInstrumentCart();
        if (instruments == null)
            return 0;
        for (CountInstruments ci :instruments) {
            orderSum+=ci.getSum();
        }
        return orderSum;
    }

    public void setCartSum(Integer sum) {
        List<CountInstruments> cis = getInstrumentCart();
        if (cis == null || cis.size() == 0)
            this.cartSum = 0;
        if (cis != null && cis.size() != 0)
        {
            Integer _cartSum = 0;
            for (CountInstruments ci:cis) {
                _cartSum += ci.getSum();
            }
            this.cartSum = _cartSum;
        }
        this.cartSum = 0;
    }
}