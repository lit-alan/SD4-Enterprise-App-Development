package com.sd4.L11.entitys;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    public RefreshToken() {}

    public RefreshToken(String token, Instant expiryDate, Customer customer) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.customer = customer;
    }

    public Long getId() { return id; }
    public String getToken() { return token; }
    public Instant getExpiryDate() { return expiryDate; }
    public Customer getCustomer() { return customer; }
}
