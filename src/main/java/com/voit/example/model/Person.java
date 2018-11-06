package com.voit.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
 * Class representing a person.
 *
 * @author mark voit
 */
@Entity
@Data
@Table(name = "person")
@EqualsAndHashCode(exclude = { "version", "createdAt", "updatedAt" })
@ToString(exclude = { "version", "createdAt", "updatedAt" })
public class Person implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Version
    @Column(name = "version")
    private Long version = 1L;

    @NotNull
    @Email
    @Length(min = 5, max = 80)
    @Column(name = "email", nullable = false, unique=true, length = 80)
    private String email;

    @Length(min = 0, max = 50)
    @Column(name = "first_name", nullable = true, length = 50)
    private String firstname;

    @Length(min = 1, max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ssZZZ", timezone = "UTC")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ssZZZ", timezone = "UTC")
    @UpdateTimestamp
    private Date updatedAt;


    public Person() {
        this.isActive = true;
    }

    public Person(String email, String firstname, String lastname) {
        this();
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
