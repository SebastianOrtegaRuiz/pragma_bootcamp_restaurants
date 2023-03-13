package com.pragma.restaurant.application.handler.impl;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.application.dto.response.CategoryResponseDto;
import com.pragma.restaurant.application.handler.ICategoryHandler;
import com.pragma.restaurant.application.mapper.category.ICategoryRequestMapper;
import com.pragma.restaurant.application.mapper.category.ICategoryResponseMapper;
import com.pragma.restaurant.domain.api.ICategoryServicePort;
import com.pragma.restaurant.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;
    @Override
    public void saveCategory(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryRequestMapper.toCategory(categoryRequestDto);
        categoryServicePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryResponseMapper.toResponseList(categoryServicePort.getAllCategory());
    }
}
