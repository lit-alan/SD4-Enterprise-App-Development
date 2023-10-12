package model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "accounts", schema = "bankofmunster", catalog = "")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AccountNumber")
    private int accountNumber;
    @Basic
    @Column(name = "FirstName")
    private String firstName;
    @Basic
    @Column(name = "LastName")
    private String lastName;
    @Basic
    @Column(name = "SortCode")
    private String sortCode;
    @Basic
    @Column(name = "Balance")
    private double balance;


}
