package com.javanildos.desafio.repositories;

import com.javanildos.desafio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByName(String name);
    User findUserByCpf(Long cpf);
}
