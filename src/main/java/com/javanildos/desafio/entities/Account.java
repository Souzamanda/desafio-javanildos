package com.javanildos.desafio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "account_number", unique = true, nullable = false)
    private Long accountNumber;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private BigDecimal balance;

    public Account(UUID accountId, Long accountNumber, AccountType accountType, User user) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.user = user;
        this.balance = new BigDecimal("0");
    }
}
