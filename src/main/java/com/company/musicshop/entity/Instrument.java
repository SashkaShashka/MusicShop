package com.company.musicshop.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "INSTRUMENT")
@Entity
public class Instrument {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OneToMany(mappedBy = "instrument")
    private List<CountInstruments> counts;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "YEAR_MANUFACTURE")
    @Temporal(TemporalType.DATE)
    private Date yearManufacture;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "WARRANTY", nullable = false)
    @NotNull
    private Integer warranty;

    @Column(name = "QUANTITY", nullable = false)
    @NotNull
    private Integer quantity;

    @Positive
    @Column(name = "PRICE", nullable = false)
    @NotNull
    private Integer price;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<CountInstruments> getCounts() {
        return counts;
    }

    public void setCounts(List<CountInstruments> counts) {
        this.counts = counts;
    }

    public Date getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(Date yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}