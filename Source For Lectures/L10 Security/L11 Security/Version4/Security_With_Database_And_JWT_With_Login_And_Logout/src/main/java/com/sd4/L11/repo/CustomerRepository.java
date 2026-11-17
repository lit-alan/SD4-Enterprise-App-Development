package com.sd4.L11.repo;

import com.sd4.L11.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //permits looking up a customer by their email address
    Optional<Customer> findByEmail(String email);
}