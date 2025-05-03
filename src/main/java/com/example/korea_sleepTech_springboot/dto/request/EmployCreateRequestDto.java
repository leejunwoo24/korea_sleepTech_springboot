package com.example.korea_sleepTech_springboot.dto.request;

import com.example.korea_sleepTech_springboot.entity.Z_Job;
import com.example.korea_sleepTech_springboot.entity.Z_Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployCreateRequestDto {
    private String name;
    private Z_Position position;
    private Z_Job job;
    private long salary;
}
