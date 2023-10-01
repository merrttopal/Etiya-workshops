package com.example.springhomework.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "Languages")
//@Data()
@Getter()
@Setter()
@NoArgsConstructor()
@AllArgsConstructor()
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language")
    List<Technology> technologies;

}
