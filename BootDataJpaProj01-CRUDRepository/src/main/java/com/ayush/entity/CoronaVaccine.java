package com.ayush.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "CorronaVaccine") //optional if want to use db table name same as entity class name
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CoronaVaccine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //dynamically generates this properties value
    private Long regNo;

    @NonNull
    @Column(name="vaccineName") //optional if want to take property name as the column name
    private String vaccineName;

    @NonNull
    @Column(length = 20) //length is only used for string type property
    private String company;

    @NonNull
    @Column(length = 20)
    private String country;

    @NonNull
    private Double price;

    @NonNull
    private Integer quantity;

}
