package com.company.musicshop.entity;

import com.company.planner.Status;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_", indexes = {
        @Index(name = "IDX_ORDER__CUSTOMER", columnList = "CUSTOMER_ID")
})
@Entity(name = "Order_")
public class Order {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "ORDER_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date orderDate;

    @Column(name = "STATUS", nullable = false)
    @NotNull
    private String status;

    @Column(name = "ORDERSUM", nullable = false)
    @NotNull
    private Integer orderSum;

    @JoinTable(name = "ORDER_COUNT_INSTRUMENTS_LINK",
            joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COUNT_INSTRUMENTS_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<CountInstruments> instrumentOrder;

    @NotNull
    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CountInstruments> getInstrumentOrder() {
        return instrumentOrder;
    }

    public void setInstrumentOrder(List<CountInstruments> instrumentOrder) {
        this.instrumentOrder = instrumentOrder;
    }

    public Status getStatus() {
        return status == null ? null : Status.fromId(status);
    }

    public void setStatus(Status status) {
        this.status = status == null ? null : status.getId();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getOrderSum(){
        Integer orderSum = 0;
        List<CountInstruments> instruments = getInstrumentOrder();
        if (instruments == null)
            return 0;
        for (CountInstruments ci :instruments) {
            orderSum+=ci.getSum();
        }
        return orderSum;
    }

    @InstanceName
    @DependsOnProperties({"status"})
    public String getInstanceName() {
        return String.format("%s", status);
    }
}