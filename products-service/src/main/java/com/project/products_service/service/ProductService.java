package com.project.products_service.service;

import com.project.products_service.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> listProduct();
    ProductDto getProductById(Long idProduct);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProductById(Long idProduct);


}
