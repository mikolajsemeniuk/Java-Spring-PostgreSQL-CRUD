package com.example.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Getter
    @Id
    @SequenceGenerator(
        name = "customer_sequence",
        sequenceName = "customer_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_sequence"
    )
    private Long id;
    @Getter @Setter
    @Column(nullable = false, updatable = true)
    private String name;
    @Column(nullable = false, updatable = true)
    @Getter @Setter
    private String surname;
    @Column(nullable = false, updatable = false)
    @Getter @Setter
    private LocalDateTime created = LocalDateTime.now();

    public CustomerEntity() { }
    public CustomerEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("id: ")
            .append(id)
            .append(", name: ")
            .append(name)
            .append(", surname: ")
            .append(surname)
            .toString();
    }
}
