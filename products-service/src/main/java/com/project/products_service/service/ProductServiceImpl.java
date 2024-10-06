package com.project.products_service.service;

import com.project.products_service.codegen.types.ProductDto;
import com.project.products_service.entity.Product;
import com.project.products_service.exception.ProductNotFoundException;
import com.project.products_service.mapper.ProductMapper;
import com.project.products_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = ProductMapper.mapper.productDtoToProduct(productDto);
        product.setIdProduct(UUID.randomUUID().toString());
        return productRepository.save(product);
        //return ProductMapper.mapper.productToProductDto(productRepository.save(product));
    }

    @Override
    public List<Product> listProduct() {
        //return ProductMapper.mapper.productsToProductDtos(productRepository.findAll());
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String idProduct) {
        //return ProductMapper.mapper.productToProductDto(helper(idProduct));
        return helper(idProduct);
    }

    @Override
    public Product updateProduct(String idProduct,ProductDto productDto) {
        Product product =helper(idProduct);
        product.setCategory(productDto.getCategory());
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        //return ProductMapper.mapper.productToProductDto(productRepository.save(product));
        return productRepository.save(product);
    }

    @Override
    public String deleteProductById(String idProduct) {
        Product product = helper(idProduct);
        productRepository.delete(product);
        return "product deleted";
    }

    public Product helper(String idProduct) {
        return productRepository.findById(idProduct).orElseThrow(()->new ProductNotFoundException(idProduct));    }
}
