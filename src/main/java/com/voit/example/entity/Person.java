package com.voit.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * Class representing a person.
 *
 * @author mark voit
 */
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true, length = 80)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    private Boolean active;


    public Person() {
        this.createdDate = new Date();
        this.active = true;
    }

    public Person(String email, String firstname, String lastname) {
        this();
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
