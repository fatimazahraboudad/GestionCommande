package com.project.products_service.service;


import com.project.products_service.codegen.types.ProductDto;
import com.project.products_service.dto.OrderLineDto;
import com.project.products_service.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductDto productDto);
    List<Product> listProduct();
    Product getProductById(String idProduct);
    Product updateProduct(String idProduct,ProductDto productDto);
    String deleteProductById(String idProduct);
    boolean checkProductInStock(List<OrderLineDto> orderLineDto);


}
