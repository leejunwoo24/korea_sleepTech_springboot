package com.example.korea_sleepTech_springboot.controller;

import com.example.korea_sleepTech_springboot.common.EmployApiMappingPattern;
import com.example.korea_sleepTech_springboot.dto.request.EmployCreateRequestDto;
import com.example.korea_sleepTech_springboot.dto.request.EmployUpdateRequestDto;
import com.example.korea_sleepTech_springboot.dto.response.EmployResponseDto;
import com.example.korea_sleepTech_springboot.service.EmployService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EmployApiMappingPattern.EmployAPI)
@RequiredArgsConstructor
public class EmployController {

    private final EmployService employService;


    @PostMapping
    public EmployResponseDto createEmploy(@RequestBody EmployCreateRequestDto requestDto){
        EmployResponseDto createResponseDto = EmployService.createEmploy(requestDto);

        return createResponseDto;
    }


    @GetMapping
    public List<EmployResponseDto> allGetEmploy(){
        List<EmployResponseDto> allGetResponseDto = EmployService.allGetEmploy();
        return allGetResponseDto;
    }

    @GetMapping("/{id}")
    public EmployResponseDto findIdGetEmploy(@PathVariable long id){
        EmployResponseDto findIdGetResponseDto = EmployService.findIdGetEmploy(id);

        return findIdGetResponseDto;

    }


    @PutMapping("/{id}")
    public EmployResponseDto putEmploy(@PathVariable long id, @RequestBody EmployUpdateRequestDto requestDto){
        EmployResponseDto putResponseDto = EmployService.putEmploy(id, requestDto);
        return putResponseDto;
    }


    @DeleteMapping("/{id}")
    public void deleteEmploy(@PathVariable long id){
        EmployService.deleteEmploy(id);

    }


}
