package com.sd4.L11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@EnableWebSecurity
public class Security_With_Database_And_JWT_With_Login_And_Logout {

    public static void main(String[] args) {
        SpringApplication.run(Security_With_Database_And_JWT_With_Login_And_Logout.class, args);
    }

}
