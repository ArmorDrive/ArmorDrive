package com.ua.armordrive.armor_drive.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


public class SaleListingDTO {

    private Long id;

    @Size(max = 255)
    private String model;

    private List<@Size(max = 255) String> pictures;

    private Integer price;

    private Integer seatsNumber;

    private Double engineDisplacement;

    private Integer kilometerage;

    private LocalDate productionYear;

    private LocalDate publishingDate;

    @Size(max = 255)
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
