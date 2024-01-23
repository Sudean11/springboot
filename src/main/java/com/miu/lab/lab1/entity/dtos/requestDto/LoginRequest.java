package com.miu.lab.lab1.entity.dtos.requestDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
