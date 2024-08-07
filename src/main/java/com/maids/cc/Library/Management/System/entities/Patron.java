package com.maids.cc.Library.Management.System.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patron")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private Long name;

    @Column(name = "email")
    private Long email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

}
