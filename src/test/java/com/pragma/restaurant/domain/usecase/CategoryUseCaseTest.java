package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.domain.spi.ICategoryPersistencePort;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    CategoryUseCase categoryUseCase;

    @Test
    void mustSaveACategory() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        CategoryModel categoryModel = new CategoryModel(1L,
                "cualquier categoria",
                "categoria de prueba");

        //When
        //Comportamiento esperado de los metodos
        when(categoryPersistencePort.saveCategory(any())).thenReturn(categoryModel);
        categoryUseCase.saveCategory(categoryModel);

        //Then
        //Se comprueba que se guarde la categoria
        verify(categoryPersistencePort).saveCategory(any(CategoryModel.class));
    }

    @Test
    void mustReturnAllCategories() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        List<CategoryModel> categoryModelList = new ArrayList<>();
        CategoryModel categoryModel = new CategoryModel(1L,
                "cualquier categoria",
                "categoria de prueba");

        categoryModelList.add(categoryModel);
        categoryModelList.add(categoryModel);
        categoryModelList.add(categoryModel);

        //When
        //Comportamiento esperado de los metodos
        when(categoryPersistencePort.getAllCategory()).thenReturn(categoryModelList);
        categoryUseCase.getAllCategory();

        //Then
        //Se comprueba que se obtengan todas las categorias
        verify(categoryPersistencePort).getAllCategory();
    }
}