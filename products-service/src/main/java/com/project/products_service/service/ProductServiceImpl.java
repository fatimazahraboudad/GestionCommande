package com.project.products_service.service;

import com.project.products_service.dto.ProductDto;
import com.project.products_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public ProductDto addProduct(ProductDto productDto) {

        return null;
    }

    @Override
    public List<ProductDto> listProduct() {
        return null;
    }

    @Override
    public ProductDto getProductById(Long idProduct) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProductById(Long idProduct) {

    }
}
