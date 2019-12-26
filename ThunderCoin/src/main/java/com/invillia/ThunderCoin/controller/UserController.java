package com.invillia.ThunderCoin.controller;

import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
import com.invillia.ThunderCoin.domain.request.UserUpdateRequest;
import com.invillia.ThunderCoin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveRequest userSaveRequest){
        Long idSave = userService.save(userSaveRequest);
        return new ResponseEntity(idSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Long id){

        Long idUpdate = userService.update(userUpdateRequest, id);
        return new ResponseEntity(idUpdate, HttpStatus.OK);
    }

}
