package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.application.dto.response.CategoryResponseDto;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getAllCategories();

}
