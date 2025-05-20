package com.example.korea_sleepTech_springboot.dto.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DemoteFromAdminResponseDto {
    private String email;
    private List<String> roles;
    private String message;
}
