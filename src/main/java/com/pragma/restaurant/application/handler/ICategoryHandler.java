package com.pragma.restaurant.application.handler;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.application.dto.response.CategoryResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(CategoryRequestDto categoryRequestDto);

    Page<CategoryResponseDto> getAllCategories(int page, int records);

}
