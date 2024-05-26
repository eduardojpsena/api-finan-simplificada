package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.common.enums.EnumError;
import com.api_financeira_simplificada.domain.user.User;
import com.api_financeira_simplificada.dto.UserDTO;
import com.api_financeira_simplificada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(UserDTO userRequest) {
        User newUser = new User();
        newUser.setName(userRequest.name());
        newUser.setDocument(userRequest.document());
        newUser.setEmail(userRequest.email());
        newUser.setPassword(userRequest.password());
        newUser.setUserType(userRequest.userType());
        newUser.setBalance(userRequest.balance());

        this.saveUser(newUser);

        return newUser;
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new Exception(EnumError.USUARIO_NAO_ENCONTRADO.getMessage()));
    }

    public List<User> findAllUsers() {
        return this.repository.findAll();
    }

}
