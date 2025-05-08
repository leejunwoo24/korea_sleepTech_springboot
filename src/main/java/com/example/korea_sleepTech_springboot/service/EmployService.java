package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.request.EmployCreateRequestDto;
import com.example.korea_sleepTech_springboot.dto.request.EmployUpdateRequestDto;
import com.example.korea_sleepTech_springboot.dto.response.EmployResponseDto;
import com.example.korea_sleepTech_springboot.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.entity.Z_Employ;
import com.example.korea_sleepTech_springboot.repository.EmployRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployService {
    private final EmployRepository employRepository;

    public  EmployResponseDto createEmploy(EmployCreateRequestDto requestDto) {
        EmployResponseDto response = null;

        try{
            Z_Employ saveDto = new Z_Employ(
                     null,
                    requestDto.getName(),
                    requestDto.getPosition(),
                    requestDto.getJob(),
                    requestDto.getSalary()
            );

            Z_Employ responseDto = employRepository.save(saveDto);


            response = new EmployResponseDto(
              responseDto.getName(),
              responseDto.getPosition(),
              responseDto.getJob(),
              responseDto.getSalary()
            );

            return response;
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, // HTTP 상태 코드
                    "Error occured while fetching Employ", // 에러 메시지
                    e // 예외 원인
            );
        }
    }

    public List<EmployResponseDto> allGetEmploy() {
        List<EmployResponseDto> list = null;

              try{
                  List<Z_Employ> employs = employRepository.findAll();

                  list = employs.stream().
                          map(employ -> new EmployResponseDto(
                                    employ.getName(),
                                    employ.getPosition(),
                                    employ.getJob(),
                                    employ.getSalary()
                                  )).
                          collect(Collectors.toList());

                  return list;
              }catch(Exception e){
                  throw new ResponseStatusException(
                          HttpStatus.INTERNAL_SERVER_ERROR, // HTTP 상태 코드
                          "Error occured while fetching Employ", // 에러 메시지
                          e // 예외 원인
                  );
              }

    }

    public EmployResponseDto findIdGetEmploy(Long id) {
        EmployResponseDto response = null;


        try{
            Z_Employ employ = employRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 책을 찾을 수 없습니다: " + id));

            response = new EmployResponseDto(
                    employ.getName(),
                    employ.getPosition(),
                    employ.getJob(),
                    employ.getSalary()
            );

            return response;
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, // HTTP 상태 코드
                    "Error occured while fetching Employ", // 에러 메시지
                    e // 예외 원인
            );
        }
    }

    public EmployResponseDto putEmploy(long id, EmployUpdateRequestDto requestDto) {
        EmployResponseDto result = null;

        try{
            Z_Employ employ = employRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 책을 찾을 수 없습니다: " + id));

            employ.setJob(requestDto.getJob());
            employ.setPosition(requestDto.getPosition());
            employ.setSalary(requestDto.getSalary());

          Z_Employ resultEmploy = employRepository.save(employ);

          result = new EmployResponseDto(
                  resultEmploy.getName(),
                  resultEmploy.getPosition(),
                  resultEmploy.getJob(),
                  resultEmploy.getSalary()
          );

          return result;
        } catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, // HTTP 상태 코드
                    "Error occured while fetching Employ", // 에러 메시지
                    e // 예외 원인
            );
        }
    }

    public  void deleteEmploy(Long id) {
        try{
            employRepository.deleteById(id);
        } catch(Exception e){
            System.out.println(e.getMessage() + "존제하지 않는 엔티티입니다.");
        }
    }
}
