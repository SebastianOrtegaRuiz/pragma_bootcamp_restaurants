package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.domain.spi.IDishesPersistencePort;
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
class DishesUseCaseTest {
    @Mock
    IDishesPersistencePort dishesPersistencePort;

    @InjectMocks
    DishesUseCase dishesUseCase;

    @Test
    void mustSaveADish() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        DishesModel dishesModel = new DishesModel(1L,
                "Pizza", 1L,"Pepperoni Pizza", 24000,
                1L, "image", true);

        //When
        //Comportamiento esperado de los metodos
        when(dishesPersistencePort.saveDishes(any())).thenReturn(dishesModel);
        dishesUseCase.saveDishes(dishesModel);

        //Then
        //Se comprueba que se guarde el plato
        verify(dishesPersistencePort).saveDishes(any(DishesModel.class));
    }

    @Test
    void mustReturnAllDishes() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        List<DishesModel> dishesModelList = new ArrayList<>();
        DishesModel dishesModel = new DishesModel(1L,
                "Pizza", 1L,"Pepperoni Pizza", 24000,
                1L, "image", true);

        dishesModelList.add(dishesModel);
        dishesModelList.add(dishesModel);
        dishesModelList.add(dishesModel);

        //When
        //Comportamiento esperado de los metodos
        when(dishesPersistencePort.getAllDishes()).thenReturn(dishesModelList);
        dishesUseCase.getAllDishes();

        //Then
        //Se comprueba que se obtengan todos los platos
        verify(dishesPersistencePort).getAllDishes();
    }
}