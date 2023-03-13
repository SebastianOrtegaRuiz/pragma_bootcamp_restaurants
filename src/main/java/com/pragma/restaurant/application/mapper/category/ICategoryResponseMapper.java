package com.pragma.restaurant.application.mapper.category;

import com.pragma.restaurant.application.dto.response.CategoryResponseDto;
import com.pragma.restaurant.domain.model.CategoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryResponseMapper {

    CategoryResponseDto toResponse(CategoryModel categoryModel);

    List<CategoryResponseDto> toResponseList(List<CategoryModel> categoryModelList);
}
