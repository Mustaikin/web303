package ru.facture.main.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "product_tab", schema = "eq_shop")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id",nullable = false)
    private Manufacturer manufacturer;
}
