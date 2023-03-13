package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import com.pragma.restaurant.infraestructure.output.mapper.ICategoryEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.ICategoryRepository;
import org.junit.jupiter.api.Assertions;
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
class CategoryJpaAdapterTest {

    @Mock
    ICategoryRepository categoryRepository;

    @Mock
    ICategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    CategoryJpaAdapter categoryJpaAdapter;

    @Test
    void mustSaveACategory() {
        //Given
        //Se necesita un modelo y una entidad de categorias
        CategoryModel categoryModel = new CategoryModel(1L,
                "cualquier categoria",
                "categoria de prueba");
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(1L);
        categoryEntity.setName("cualquier categoria");
        categoryEntity.setDescription("categoria de prueba");

        //When
        //se comprueba que se ejecuten las acciones correspondientes
        when(categoryEntityMapper.toEntity(any())).thenReturn(categoryEntity);
        when(categoryRepository.save(any())).thenReturn(categoryEntity);
        when(categoryEntityMapper.toCategoryModel(any())).thenReturn(categoryModel);
        categoryJpaAdapter.saveCategory(categoryModel);

        //Then
        //Se verifica que se guarde correctamente
        verify(categoryRepository).save(any(CategoryEntity.class));
    }

    @Test
    void saveAnInvalidCategory() {
        //Given
        //se requiere una entidad de categorias y un modelo
        CategoryModel categoryModel = new CategoryModel(null,
                null,
                null);
        CategoryEntity categoryEntity = new CategoryEntity();

        //When
        //lo que debe hacer el método
        when(categoryEntityMapper.toEntity(any())).thenReturn(categoryEntity);
        when(categoryRepository.save(any())).thenReturn(null);

        //Then
        //verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
           categoryJpaAdapter.saveCategory(categoryModel);
        });

    }
    @Test
    void mustReturnAllCategories() {
        //Given
        //se crean las listas que busca en la base de datos y convierte a model
        List<CategoryModel> categoryModelList = new ArrayList<>();
        List<CategoryEntity> categoryEntityList = new ArrayList<>();

        CategoryModel categoryModel = new CategoryModel(1L,
                "Pizzas",
                "todos los platos que sean de pizza");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1L);
        categoryEntity.setName("Pizzas");
        categoryEntity.setDescription("todos los platos que sean de pizza");

        categoryModelList.add(categoryModel);
        categoryModelList.add(categoryModel);

        categoryEntityList.add(categoryEntity);
        categoryEntityList.add(categoryEntity);

        //When
        //se verifica que se ejecuten cada una de las acciones
        when(categoryRepository.findAll()).thenReturn(categoryEntityList);
        when(categoryEntityMapper.toCategoryModelList(categoryEntityList)).thenReturn(categoryModelList);
        categoryJpaAdapter.getAllCategory();

        //Then
        //se verifica que se llame la funcion y no traiga nulo
        Assertions.assertNotNull(categoryEntityList);
        verify(categoryRepository).findAll();

    }

    @Test
    void notReturnRoles() {
        //Given
        //se necesita verificar que una lista venga vacía
        List<CategoryEntity> categoryEntityList = new ArrayList<>();

        //When
        //se comprueba que se haga el llamado a la base de datos
        when(categoryRepository.findAll()).thenReturn(categoryEntityList);

        //Then
        //Se verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            categoryJpaAdapter.getAllCategory();
        });

    }
}