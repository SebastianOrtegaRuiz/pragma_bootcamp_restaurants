package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IDishesEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IDishesRepository;
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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DishesJpaAdapterTest {

    @Mock
    IDishesRepository dishesRepository;

    @Mock
    IDishesEntityMapper dishesEntityMapper;

    @InjectMocks
    DishesJpaAdapter dishesJpaAdapter;

    @Test
    void mustSaveADish() {
        //Given
        //entidad y modelo necesarios para ejecutar los metodos
        DishesModel dishesModel = new DishesModel(1L,
        "Pizza", 1L,"Pepperoni Pizza", 24000,
        1L, "image", true);

        DishesEntity dishesEntity = new DishesEntity();
        dishesEntity.setId(1L);
        dishesEntity.setName("Pizza");
        dishesEntity.setId_category(1L);
        dishesEntity.setDescription("Pepperoni Pizza");
        dishesEntity.setPrice(24000);
        dishesEntity.setId_restaurant(1L);
        dishesEntity.setUrl_image("imagen");
        dishesEntity.setActive(true);

        //When
        //acciones que realiza el metodo
        when(dishesEntityMapper.toEntity(any())).thenReturn(dishesEntity);
        when(dishesRepository.save(any())).thenReturn(dishesEntity);
        when(dishesEntityMapper.toDishesModel(any())).thenReturn(dishesModel);
        dishesJpaAdapter.saveDishes(dishesModel);

        //Then
        //verifica que se ejecute el metodo
        verify(dishesRepository).save(any(DishesEntity.class));

    }

    @Test
    void saveAnInvalidDish() {
        //Given
        //Se necesita un modelo y una entidad vacia o nula
        DishesModel dishesModel = new DishesModel(null, null, null, null,
                0, null, null, null);
        DishesEntity dishesEntity = new DishesEntity();

        //When
        //Se define el comportamiento cuando guarda o convierte objetos
        when(dishesEntityMapper.toEntity(any())).thenReturn(dishesEntity);
        when(dishesRepository.save(any())).thenReturn(null);

        //Then
        //se verifica que se lance una excepcion cuando se intenta guardar un modelo nulo
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            dishesJpaAdapter.saveDishes(dishesModel);
        });
    }

    @Test
    void mustReturnAllDishes() {
        //Given
        //se crean las listas que busca en la base de datos y convierte a model
        List<DishesModel> dishesModelList = new ArrayList<>();
        List<DishesEntity> dishesEntityList = new ArrayList<>();

        DishesModel dishesModel = new DishesModel(1L,
                "Pizza", 1L,"Pepperoni Pizza", 24000,
                1L, "image", true);

        DishesEntity dishesEntity = new DishesEntity();
        dishesEntity.setId(1L);
        dishesEntity.setName("Pizza");
        dishesEntity.setId_category(1L);
        dishesEntity.setDescription("Pepperoni Pizza");
        dishesEntity.setPrice(24000);
        dishesEntity.setId_restaurant(1L);
        dishesEntity.setUrl_image("imagen");
        dishesEntity.setActive(true);

        dishesModelList.add(dishesModel);
        dishesModelList.add(dishesModel);

        dishesEntityList.add(dishesEntity);
        dishesEntityList.add(dishesEntity);

        //When
        //se verifica que se ejecuten cada una de las acciones
        when(dishesRepository.findAll()).thenReturn(dishesEntityList);
        when(dishesEntityMapper.toDishesModelList(dishesEntityList)).thenReturn(dishesModelList);
        dishesJpaAdapter.getAllDishes();

        //Then
        //se verifica que se llame la funcion y no traiga nulo
        Assertions.assertNotNull(dishesEntityList);
        verify(dishesRepository).findAll();
    }

    @Test
    void notReturnDishes() {
        //Given
        //se necesita verificar que una lista venga vacía
        List<DishesEntity> dishesEntityList = new ArrayList<>();

        //When
        //se comprueba que se haga el llamado a la base de datos
        when(dishesRepository.findAll()).thenReturn(dishesEntityList);

        //Then
        //Se verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            dishesJpaAdapter.getAllDishes();
        });
    }

}