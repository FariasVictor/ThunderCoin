package com.invillia.ThunderCoin.service;

import com.invillia.ThunderCoin.domain.User;
import com.invillia.ThunderCoin.repository.UserRepository;
import com.invillia.ThunderCoin.service.gerenic.CrudGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CrudGeneric<User, Long> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Long save(User entity) {
        return null;
    }

    @Override
    public Long update(User entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
