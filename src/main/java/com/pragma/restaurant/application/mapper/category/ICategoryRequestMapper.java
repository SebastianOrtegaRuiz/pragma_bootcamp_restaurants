package com.pragma.restaurant.application.mapper.category;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.domain.model.CategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {
    CategoryModel toCategory(CategoryRequestDto categoryRequestDto);
}
