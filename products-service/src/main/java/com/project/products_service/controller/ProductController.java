package com.project.products_service.controller;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.project.products_service.codegen.types.ProductDto;
import com.project.products_service.dto.OrderLineDto;
import com.project.products_service.entity.Product;
import com.project.products_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @DgsQuery
    public List<Product> getProducts() {
        return productService.listProduct();
    }

    @DgsQuery
    public Product getProductById(String idProduct) {
        return productService.getProductById(idProduct);
    }

    @DgsMutation
    public Product addProduct(@InputArgument ProductDto productDto) {
        return productService.addProduct(productDto);
    }


    @DgsMutation
    public Product updateProduct(@InputArgument String idProduct, @InputArgument ProductDto productDto) {
        return productService.updateProduct(idProduct,productDto);
    }

    @DgsMutation
    public String deleteProduct(@InputArgument String idProduct) {
        return productService.deleteProductById(idProduct);
    }


}
