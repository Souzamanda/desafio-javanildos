package com.javanildos.desafio.repositories;

import com.javanildos.desafio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByName(String name);
    Optional<User> findUserByCpf(String cpf);
}
