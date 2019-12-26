package com.invillia.ThunderCoin.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserSaveRequest {

    @NotBlank
    private Long employeeId;

    @NotBlank
    private String name;

}
