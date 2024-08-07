package com.maids.cc.Library.Management.System.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

}
