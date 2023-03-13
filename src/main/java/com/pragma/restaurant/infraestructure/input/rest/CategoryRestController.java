package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.application.dto.response.CategoryResponseDto;
import com.pragma.restaurant.application.handler.ICategoryHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Api(value = "Category CRUD, you can create and administrate new categories of plates for every restaurant")
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @ApiOperation(value = "Save a category")
    @PostMapping("/")
    public ResponseEntity<Void> saveCategory(@ApiParam(value = "require a JSON format Object to save a category", required = true) @RequestBody CategoryRequestDto categoryRequestDto) {
        categoryHandler.saveCategory(categoryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all categories", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory() {
        return ResponseEntity.ok(categoryHandler.getAllCategories());
    }
}
