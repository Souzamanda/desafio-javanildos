package com.javanildos.desafio.repositories;

import com.javanildos.desafio.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query(value = "SELECT * FROM tb_account WHERE user_id = :id", nativeQuery = true)
    Set<Account> findAccountsByUserId(@Param("id") UUID id);
}
