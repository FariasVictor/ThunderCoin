package com.invillia.ThunderCoin.mapper;

import com.invillia.ThunderCoin.domain.User;
import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
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

}
