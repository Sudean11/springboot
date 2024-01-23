package com.miu.lab.lab1.services;


import com.miu.lab.lab1.entity.dtos.requestDto.LoginRequest;
import com.miu.lab.lab1.entity.dtos.requestDto.RefreshTokenRequest;
import com.miu.lab.lab1.entity.dtos.responseDto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
