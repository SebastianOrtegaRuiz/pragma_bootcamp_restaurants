package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.domain.spi.IRestaurantsPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantsUseCaseTest {
    @Mock
    IRestaurantsPersistencePort restaurantsPersistencePort;

    @InjectMocks
    RestaurantsUseCase restaurantsUseCase;

    @Test
    void mustSaveARestaurant() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        RestaurantsModel restaurantsModel = new RestaurantsModel(1L, "Don Karlos",
                "Cra 8 # 10-57", 1L, "+571234567891", "Image", 1203345L);

        //When
        //Comportamiento esperado de los metodos
        when(restaurantsPersistencePort.saveRestaurants(any())).thenReturn(restaurantsModel);
        restaurantsUseCase.saveRestaurants(restaurantsModel);

        //Then
        //Se comprueba que se guarde el restaurante
        verify(restaurantsPersistencePort).saveRestaurants(any(RestaurantsModel.class));
    }

    @Test
    void mustReturnAllRestaurants() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        List<RestaurantsModel> restaurantsModelList = new ArrayList<>();
        RestaurantsModel restaurantsModel = new RestaurantsModel(1L, "Don Karlos",
                "Cra 8 # 10-57", 1L, "+571234567891", "Image", 1203345L);
        
        restaurantsModelList.add(restaurantsModel);
        restaurantsModelList.add(restaurantsModel);
        restaurantsModelList.add(restaurantsModel);

        //When
        //Comportamiento esperado de los metodos
        when(restaurantsPersistencePort.getAllRestaurants(1, 1)).thenReturn(Page.empty());
        restaurantsUseCase.getAllRestaurants(1, 1);

        //Then
        //Se comprueba que se obtengan todos los restaurantes
        verify(restaurantsPersistencePort).getAllRestaurants(1, 1);
    }
}