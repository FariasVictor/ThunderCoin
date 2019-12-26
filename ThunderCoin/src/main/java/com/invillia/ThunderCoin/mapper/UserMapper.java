package com.invillia.ThunderCoin.mapper;

import com.invillia.ThunderCoin.domain.User;
import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
import com.invillia.ThunderCoin.domain.request.UserUpdateRequest;
import com.invillia.ThunderCoin.domain.response.UserResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserMapper {

    public User UserSaveRequestToUser(UserSaveRequest userSaveRequest){
        User user = new User();

        user.setEmployeeId(userSaveRequest.getEmployeeId());
        user.setName(userSaveRequest.getName());
        user.setBalance(new BigDecimal("0"));

        return user;
    }

    public void updateUserByUserUpdateRequest(User user, UserUpdateRequest userUpdateRequest) {

        user.setName(userUpdateRequest.getName());
        user.setBalance(userUpdateRequest.getBalance());
    }

    public UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setEmployeeId(user.getEmployeeId());
        userResponse.setName(user.getName());
        userResponse.setBalance(user.getBalance());

        return userResponse;

    }
}
