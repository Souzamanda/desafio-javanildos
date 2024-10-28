package com.javanildos.desafio.services;

import com.javanildos.desafio.dtos.CreateUserDto;
import com.javanildos.desafio.entities.User;
import com.javanildos.desafio.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User saveUser(CreateUserDto payload) {
        User user = new User();
        user.setName(payload.name());
        user.setCpf(payload.cpf());

        return userRepository.save(user);
    }

    public String updateUser(String cpf, CreateUserDto payload) {
        var user = getUserByCPF(cpf);
        BeanUtils.copyProperties(payload, user);
        userRepository.save(user);

        return "Usuário modificado. " + user;
    }

    public String deleteUser(String cpf) {
        var user = getUserByCPF(cpf);

        userRepository.delete(user);
        return "Usuário deletado.";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByCPF(String cpf) {
        return userRepository.findUserByCpf(cpf).orElseThrow(() -> new RuntimeException("Não existe usuário cadastrado com esse CPF."));
    }
}
