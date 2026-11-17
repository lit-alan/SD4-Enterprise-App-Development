package com.sd4.L11.repo;

import com.sd4.L11.entitys.Customer;
import com.sd4.L11.entitys.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByCustomer(Customer customer);
}
