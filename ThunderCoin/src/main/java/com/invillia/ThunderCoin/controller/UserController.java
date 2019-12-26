package com.invillia.ThunderCoin.controller;

import com.invillia.ThunderCoin.domain.request.UserSaveRequest;
import com.invillia.ThunderCoin.domain.request.UserUpdateRequest;
import com.invillia.ThunderCoin.domain.response.UserResponse;
import com.invillia.ThunderCoin.service.UserService;
import org.apache.coyote.Response;
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

    @GetMapping("/{id}")
    public ResponseEntity findByEmployeeId(@PathVariable Long id){
        return new ResponseEntity(
                userService.findByEmployeeId(id),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Long id){
        return new ResponseEntity(
                userService.update(userUpdateRequest, id),
                HttpStatus.OK);
    }

}
