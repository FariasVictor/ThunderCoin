package com.invillia.ThunderCoin.service;

import com.invillia.ThunderCoin.domain.User;
import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
import com.invillia.ThunderCoin.domain.request.UserUpdateRequest;
import com.invillia.ThunderCoin.domain.response.UserResponse;
import com.invillia.ThunderCoin.exception.UserNotFoundByEmployeeIdException;
import com.invillia.ThunderCoin.exception.UserWithEmployeeIdAlreadyExistsException;
import com.invillia.ThunderCoin.mapper.UserMapper;
import com.invillia.ThunderCoin.repository.UserRepository;
import com.invillia.ThunderCoin.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public Long save(UserSaveRequest userSaveRequest) {
        User user = userMapper.UserSaveRequestToUser(userSaveRequest);

        existUserWithEmployeeIdRegistred(user.getEmployeeId());

        return userRepository.save(user).getId();
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return null;
    }


    public UserResponse findByEmployeeId(Long employeeId) {
        return userMapper.userToUserResponse(findUser(employeeId));
    }

    @Transactional
    public Long update(UserUpdateRequest userUpdateRequest, Long employeeId) {

        User user = findUser(employeeId);

        userMapper.updateUserByUserUpdateRequest(user,userUpdateRequest);

        return userRepository.save(user).getId();
    }

    @Transactional
    public void delete(Long id) {

    }


    public void existUserWithEmployeeIdRegistred(Long id){
        if (userRepository.existsByEmployeeId(id)) {
            throw new UserWithEmployeeIdAlreadyExistsException(Messages.USER_EMPLOYEEID_ALREADY_EXISTS);
        }
    }

    @Transactional(readOnly = true)
    private  User findUser(Long employeeId) {
        return userRepository.findByEmployeeId(employeeId)
                .orElseThrow(
                        () -> new UserNotFoundByEmployeeIdException(
                                Messages.USER_NOT_FOUND_BY_EMPLOYEE_ID));
    }
}
