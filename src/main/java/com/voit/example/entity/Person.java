package com.voit.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @author mark voit
 */
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;


    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = new Date();
    }
}
