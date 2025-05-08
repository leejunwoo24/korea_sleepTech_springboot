package com.example.korea_sleepTech_springboot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "employ")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Z_Employ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "position", nullable = false)
    private Z_Position position;

    @Enumerated(EnumType.STRING)
    @Column(name = "job", nullable = false)
    private Z_Job job;

    @Column(name = "salary", nullable = false)
    private long salary;
}
