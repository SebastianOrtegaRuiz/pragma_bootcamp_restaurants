package com.pragma.restaurant.infraestructure.input.rest;

import com.pragma.restaurant.application.dto.request.CategoryRequestDto;
import com.pragma.restaurant.application.dto.response.CategoryResponseDto;
import com.pragma.restaurant.application.dto.response.ResponsePagedDto;
import com.pragma.restaurant.application.dto.response.restaurants.RestaurantsResponseDto;
import com.pragma.restaurant.application.handler.ICategoryHandler;
import com.pragma.restaurant.infraestructure.pagination.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    private final Pagination<CategoryResponseDto> pagination;

    @ApiOperation(value = "Save a category")
    @PostMapping("/")
    public ResponseEntity<Void> saveCategory(@ApiParam(value = "require a JSON format Object to save a category", required = true) @RequestBody CategoryRequestDto categoryRequestDto) {
        categoryHandler.saveCategory(categoryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a list of all categories", response = List.class)
    @GetMapping("/{page}/{records}")
    public ResponseEntity<ResponsePagedDto<CategoryResponseDto>> getAllCategory(@ApiParam(value = "require an int for specified the page thats needs ", required = true) @PathVariable("page") int page,
                                                                                @ApiParam(value = "require an int for specified the number of records per page", required = true) @PathVariable("records") int records) {
        Page<CategoryResponseDto> categoryResponseDto = categoryHandler.getAllCategories(page, records);

        ResponsePagedDto<CategoryResponseDto> responsePagedDto = pagination.paginate(page, categoryResponseDto);

        return ResponseEntity.ok(responsePagedDto);
    }
}
