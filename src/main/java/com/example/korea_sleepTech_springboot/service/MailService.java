package com.example.korea_sleepTech_springboot.service;

import com.example.korea_sleepTech_springboot.dto.auth.PasswordResetRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface MailService {

    Mono<ResponseEntity<String>> sendSimpleMessage(@NotBlank @Email String email);

    Mono<ResponseEntity<String>> verifyEmail(String token);


}
