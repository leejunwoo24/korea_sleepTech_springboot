package com.example.korea_sleepTech_springboot.시험.controller;


import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto<ProductResponseDto>> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto){
        try{
            ResponseDto<ProductResponseDto> product = productService.createProduct(productCreateRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }



    }

    @GetMapping("/{id}")
    public ProductResponseDto findByIdProduct(@PathVariable Long id){
        ProductResponseDto responseDto = productService.findByIdProduct(id);

        return responseDto;
    }

    @GetMapping
    public List<ProductResponseDto> findProducts(){
        List<ProductResponseDto> responseList = productService.findProducts();

        return responseList;
    }

    @PutMapping("/{id}")
    public ProductResponseDto putByIdProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        ProductResponseDto responseDto = productService.putByIdProduct(id, productUpdateRequestDto);

        return responseDto;
    }

    @DeleteMapping("/{id}")
    public void deleteByIdProduct(@PathVariable Long id){
        productService.deleteByIdProduct(id);
    }
}
