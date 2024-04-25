package com.ua.armordrive.armor_drive.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Entity
public class SaleListing {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column
    private String model;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> pictures;

    @Column
    private Integer price;

    @Column
    private Integer seatsNumber;

    @Column
    private Double engineDisplacement;

    @Column
    private Integer kilometerage;

    @Column
    private LocalDate productionYear;

    @Column
    private LocalDate publishingDate;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(final List<String> pictures) {
        this.pictures = pictures;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(final Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(final Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public Integer getKilometerage() {
        return kilometerage;
    }

    public void setKilometerage(final Integer kilometerage) {
        this.kilometerage = kilometerage;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(final LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(final LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
