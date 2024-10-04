package com.project.products_service.mapper;

import com.project.products_service.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper mapper= Mappers.getMapper(ProductMapper.class);





}
