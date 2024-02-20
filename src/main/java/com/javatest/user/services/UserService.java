package com.javatest.user.services;

import com.javatest.user.model.user.User;
import com.javatest.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método para buscar um usuário por ID
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    // Método para atualizar um usuário
    public User updateUser(Integer id, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Atualiza os campos do usuário com base nos dados fornecidos
            user.setLogin(updatedUser.getLogin());
            user.setEmail(updatedUser.getEmail());
            // Adicione outros campos conforme necessário
            // Salva o usuário atualizado no banco de dados
            return userRepository.save(user);
        } else {
            return null; // Retorna null se o usuário não for encontrado
        }
    }

    // Método para listar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}