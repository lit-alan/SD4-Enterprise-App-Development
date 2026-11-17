package com.sd4.L11.entitys;

import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //The inverse side of the many-to-many relationship with the Customer entity
    //Each Role can be associated with multiple Customers, and each Customer can have multiple Roles.
    //Using a Set is imortat here so that each customer is unique within the collection, preventing duplicates.
    @ManyToMany(mappedBy = "roles")
    private Set<Customer> customers;


    public Role() {
    }

    public Role(Long id, String name, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}