package com.example.korea_sleepTech_springboot.dto.request;

import com.example.korea_sleepTech_springboot.entity.Z_Job;
import com.example.korea_sleepTech_springboot.entity.Z_Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployUpdateRequestDto {
    private Z_Position position;
    private Z_Job job;
    private long salary;
}
