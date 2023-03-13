package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IOrdersEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IOrdersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdersJpaAdapterTest {
    @Mock
    IOrdersRepository ordersRepository;

    @Mock
    IOrdersEntityMapper ordersEntityMapper;

    @InjectMocks
    OrdersJpaAdapter ordersJpaAdapter;

    @Test
    void mustSaveAOrder() {
        //Given
        //entidad y modelo necesarios para ejecutar los metodos
        OrdersModel ordersModel = new OrdersModel(1L,
                1L,new Date(), "PREPARACION ",
                1L, 1l);

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setId(1L);
        ordersEntity.setId_client(1L);
        ordersEntity.setDate(new Date());
        ordersEntity.setStatus("PREPARACION");
        ordersEntity.setId_chef(1L);
        ordersEntity.setId_restaurant(1L);

        //When
        //acciones que realiza el metodo
        when(ordersEntityMapper.toEntity(any())).thenReturn(ordersEntity);
        when(ordersRepository.save(any())).thenReturn(ordersEntity);
        when(ordersEntityMapper.toOrdersModel(any())).thenReturn(ordersModel);
        ordersJpaAdapter.saveOrders(ordersModel);

        //Then
        //verifica que se ejecute el metodo
        verify(ordersRepository).save(any(OrdersEntity.class));

    }

    @Test
    void saveAnInvalidOrder() {
        //Given
        //Se necesita un modelo y una entidad vacia o nula
        OrdersModel ordersModel = new OrdersModel(null, null, null, null,
                null, null);
        OrdersEntity ordersEntity = new OrdersEntity();

        //When
        //Se define el comportamiento cuando guarda o convierte objetos
        when(ordersEntityMapper.toEntity(any())).thenReturn(ordersEntity);
        when(ordersRepository.save(any())).thenReturn(null);

        //Then
        //se verifica que se lance una excepcion cuando se intenta guardar un modelo nulo
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            ordersJpaAdapter.saveOrders(ordersModel);
        });
    }

    @Test
    void mustReturnAllOrders() {
        //Given
        //se crean las listas que busca en la base de datos y convierte a model
        List<OrdersModel> ordersModelList = new ArrayList<>();
        List<OrdersEntity> ordersEntityList = new ArrayList<>();

        OrdersModel ordersModel = new OrdersModel(1L,
                1L,new Date(), "PREPARACION ",
                1L, 1l);

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setId(1L);
        ordersEntity.setId_client(1L);
        ordersEntity.setDate(new Date());
        ordersEntity.setStatus("PREPARACION");
        ordersEntity.setId_chef(1L);
        ordersEntity.setId_restaurant(1L);

        ordersModelList.add(ordersModel);
        ordersModelList.add(ordersModel);

        ordersEntityList.add(ordersEntity);
        ordersEntityList.add(ordersEntity);

        //When
        //se verifica que se ejecuten cada una de las acciones
        when(ordersRepository.findAll()).thenReturn(ordersEntityList);
        when(ordersEntityMapper.toOrdersModelList(ordersEntityList)).thenReturn(ordersModelList);
        ordersJpaAdapter.getAllOrders();

        //Then
        //se verifica que se llame la funcion y no traiga nulo
        Assertions.assertNotNull(ordersEntityList);
        verify(ordersRepository).findAll();
    }

    @Test
    void notReturnOrders() {
        //Given
        //se necesita verificar que una lista venga vacía
        List<OrdersEntity> ordersEntityList = new ArrayList<>();

        //When
        //se comprueba que se haga el llamado a la base de datos
        when(ordersRepository.findAll()).thenReturn(ordersEntityList);

        //Then
        //Se verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            ordersJpaAdapter.getAllOrders();
        });
    }

}