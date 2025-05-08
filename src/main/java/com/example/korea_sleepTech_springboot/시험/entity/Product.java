package com.example.korea_sleepTech_springboot.시험.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Long created_at;

    @Column(nullable = false)
    private Long updated_at;


    @PrePersist
    public void prePersist() {
        long currentTimeMillis = System.currentTimeMillis();
        this.created_at = currentTimeMillis;
        this.updated_at = currentTimeMillis;
    }
    @PreUpdate
    public void preUpdate(){
        this.updated_at = System.currentTimeMillis();
    }
    
    public Product (Long id, String name, String description, BigDecimal price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        prePersist();
        preUpdate();
       
    }

    

}
