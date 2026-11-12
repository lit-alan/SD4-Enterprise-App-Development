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
    //Using a SEt is imortat here so that each customer is unique within the collection, preventing duplicates.
    @ManyToMany(mappedBy = "roles")
    private Set<Customer> customers;

    public Role() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<Customer> getCustomers() {
        return this.customers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }


    public String toString() {
        return "Role(id=" + this.getId() + ", name=" + this.getName() + ", customers=" + this.getCustomers() + ")";
    }
}