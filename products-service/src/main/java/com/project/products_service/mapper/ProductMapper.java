package com.project.products_service.mapper;
import com.project.products_service.codegen.types.ProductDto;
import com.project.products_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper mapper= Mappers.getMapper(ProductMapper.class);

    Product productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Product product);

    List<Product> productDtosToProducts(List<ProductDto> productDtos);
    List<ProductDto> productsToProductDtos(List<Product> products);

}
