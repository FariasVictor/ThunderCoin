package com.invillia.ThunderCoin.service;

import com.invillia.ThunderCoin.domain.User;
import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
import com.invillia.ThunderCoin.exception.UserWithEmployeeIdAlreadyExistsException;
import com.invillia.ThunderCoin.mapper.UserMapper;
import com.invillia.ThunderCoin.repository.UserRepository;
import com.invillia.ThunderCoin.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public Long save(UserSaveRequest userSaveRequest) {
        User user = userMapper.UserSaveRequestToUser(userSaveRequest);

        existUserWithEmployeeIdRegistred(user.getEmployeeId());

        return userRepository.save(user).getId();
    }


    public Long update(User entity) {
        return null;
    }


    public void delete(Long id) {

    }


    public List<User> findAll() {
        return null;
    }


    public User findById(Long id) {
        return null;
    }

    public void existUserWithEmployeeIdRegistred(Long id){
        if (userRepository.existsByEmployeeId(id)) {
            throw new UserWithEmployeeIdAlreadyExistsException(Messages.USER_EMPLOYEEID_ALREADY_EXISTS);
        }
    }
}
