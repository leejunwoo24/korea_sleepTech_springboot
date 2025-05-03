package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.EmployCreateRequestDto;
import com.example.korea_sleepTech_springboot.dto.request.EmployUpdateRequestDto;
import com.example.korea_sleepTech_springboot.dto.response.EmployResponseDto;
import com.example.korea_sleepTech_springboot.entity.Z_Employ;
import com.example.korea_sleepTech_springboot.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployService {

    private final EmployRepository employRepository;

    public static EmployResponseDto createEmploy(EmployCreateRequestDto requestDto) {

    }

    public static List<EmployResponseDto> allGetEmploy() {

    }

    public static EmployResponseDto findIdGetEmploy(long id) {

    }

    public static EmployResponseDto putEmploy(long id, EmployUpdateRequestDto requestDto) {
    }

    public static void deleteEmploy(long id) {
    }
}
