package com.javanildos.desafio.repositories;

import com.javanildos.desafio.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
