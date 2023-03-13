package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.entity.RestaurantsEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IRestaurantsEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IRestaurantsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantsJpaAdapterTest {

    @Mock
    IRestaurantsRepository restaurantsRepository;

    @Mock
    IRestaurantsEntityMapper restaurantsEntityMapper;

    @InjectMocks
    RestaurantsJpaAdapter restaurantsJpaAdapter;

    @Test
    void mustSaveARestaurant() {
        //Given
        //entidad y modelo necesarios para ejecutar los metodos
        RestaurantsModel restaurantsModel = new RestaurantsModel(1L, "Don Karlos",
                "Cra 8 # 10-57", 1L, "+571234567891", "Image", 1203345L);

        RestaurantsEntity restaurantsEntity = new RestaurantsEntity();
        restaurantsEntity.setId(1L);
        restaurantsEntity.setName("Don Karlos");
        restaurantsEntity.setAddress("Cra 8 # 10-57");
        restaurantsEntity.setId_owner(1L);
        restaurantsEntity.setPhone("+571234567891");
        restaurantsEntity.setUrl_logo("Image");
        restaurantsEntity.setNit(1203345L);

        //When
        //acciones que realiza el metodo
        when(restaurantsEntityMapper.toEntity(any())).thenReturn(restaurantsEntity);
        when(restaurantsRepository.save(any())).thenReturn(restaurantsEntity);
        when(restaurantsEntityMapper.toRestaurantsModel(any())).thenReturn(restaurantsModel);
        restaurantsJpaAdapter.saveRestaurants(restaurantsModel);

        //Then
        //verifica que se ejecute el metodo
        verify(restaurantsRepository).save(any(RestaurantsEntity.class));
    }

    @Test
    void mustReturnAllRestaurants() {
        //Given
        //
        RestaurantsModel restaurantsModel = new RestaurantsModel(1L, "Don Karlos",
                "Cra 8 # 10-57", 1L, "+571234567891", "Image", 1203345L);

        int pages = 1;
        int records = 1;

        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
        orders.add(order);

        Pageable paging = PageRequest.of(pages - 1, records, Sort.by(orders));

        //Page<RestaurantsModel> pageRestaurants = restaurantsRepository.findAll(paging).map(restaurantsEntityMapper::toRestaurantsModel);


        //When
        //
        //when(restaurantsRepository.findAll(paging).map(restaurantsEntityMapper::toRestaurantsModel)).thenReturn(pageRestaurants);
        when(restaurantsRepository.findAll(paging)).thenReturn(Page.empty());

        //Then
        //
        Assertions.assertNotNull(restaurantsRepository.findAll(paging));
        verify(restaurantsRepository).findAll(paging);

    }

    @Test
    void notReturnAllRestaurants() {

        //Given
        //se necesita verificar que la paginación venga vacía
        int pages = 1;
        int records = 1;

        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
        orders.add(order);

        Pageable paging = PageRequest.of(pages - 1, records, Sort.by(orders));

        //When
        //se comprueba que se haga el llamado a la base de datos
        when(restaurantsRepository.findAll(paging)).thenReturn(Page.empty());

        //Then
        //Se verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            restaurantsJpaAdapter.getAllRestaurants(pages, records);
        });
    }
}