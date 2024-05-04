package com.ua.armordrive.armor_drive.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ua.armordrive.armor_drive.enums.BodyType;
import com.ua.armordrive.armor_drive.enums.Brand;
import com.ua.armordrive.armor_drive.enums.FuelType;
import com.ua.armordrive.armor_drive.enums.GearBox;
import com.ua.armordrive.armor_drive.enums.State;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Entity
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    private Brand brand;
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

    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    @Enumerated(EnumType.STRING)
    private GearBox gearBox;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JsonIgnore
    User user;

}
