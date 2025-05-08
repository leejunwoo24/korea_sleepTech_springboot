package com.example.korea_sleepTech_springboot.시험.service;

import com.example.korea_sleepTech_springboot.시험.dto.request.ProductCreateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.request.ProductUpdateRequestDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ProductResponseDto;
import com.example.korea_sleepTech_springboot.시험.dto.response.ResponseDto;
import com.example.korea_sleepTech_springboot.시험.entity.Product;
import com.example.korea_sleepTech_springboot.시험.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private  final ProductRepository productRepository;


    public ResponseDto<ProductResponseDto> createProduct(ProductCreateRequestDto productCreateRequestDto) {
        ProductResponseDto productResponseDto = null;

            try{
                Product product = new Product(null, productCreateRequestDto.getName(), productCreateRequestDto.getDescription(), productCreateRequestDto.getPrice());

                Product responseProduct  = productRepository.save(product);

                productResponseDto = new ProductResponseDto(
                    responseProduct.getId(),
                    responseProduct.getName(),
                    responseProduct.getDescription(),
                    responseProduct.getPrice());

                return ResponseDto.setSuccess("새로운 상품이 등록되었습니다.", productResponseDto);
            } catch(Exception e){
                e.printStackTrace();
                return ResponseDto.setFailed("게시글 등록 중 오류가 발생하였습니다: " + e.getMessage());
        }

    }

    public ProductResponseDto findByIdProduct(Long id) {
        ProductResponseDto productResponseDto = null;

            try{
                Product responseProduct = productRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

                productResponseDto = new ProductResponseDto(
                        responseProduct.getId(),
                        responseProduct.getName(),
                        responseProduct.getDescription(),
                        responseProduct.getPrice()
                );


            }catch(Exception e){
                e.printStackTrace();
            }
        return productResponseDto;
    }

    public List<ProductResponseDto> findProducts() {
        List<ProductResponseDto> productResponseDtos = null;

            try{
                List<Product> responseProducts = productRepository.findAll();

                productResponseDtos = responseProducts.stream()
                        .map(responseProduct -> new ProductResponseDto(
                             responseProduct.getId(),
                             responseProduct.getName(),
                             responseProduct.getDescription(),
                             responseProduct.getPrice()
                        ))
                        .collect(Collectors.toList());


            }catch(Exception e){
                e.printStackTrace();
            }

        return productResponseDtos;
    }

    public ProductResponseDto putByIdProduct(Long id, ProductUpdateRequestDto productUpdateRequestDto) {
        ProductResponseDto productResponseDto = null;

            try{
                Product product = productRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

                product.setName(productUpdateRequestDto.getName());
                product.setDescription(productUpdateRequestDto.getDescription());
                product.setPrice(productUpdateRequestDto.getPrice());

                Product responseProduct = productRepository.save(product);

                productResponseDto = new ProductResponseDto(
                        responseProduct.getId(),
                        responseProduct.getName(),
                        responseProduct.getDescription(),
                        responseProduct.getPrice()
                );
            }catch(Exception e){
                e.printStackTrace();
            }

            return productResponseDto;
    }

    public void deleteByIdProduct(Long id) {
        try{
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품을 찾을 수 없습니다: " + id));

            productRepository.delete(product);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
