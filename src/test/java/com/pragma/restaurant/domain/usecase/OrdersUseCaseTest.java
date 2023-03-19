package com.pragma.restaurant.domain.usecase;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.domain.spi.IOrdersPersistencePort;
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
class OrdersUseCaseTest {
    @Mock
    IOrdersPersistencePort ordersPersistencePort;

    @InjectMocks
    OrdersUseCase ordersUseCase;

    @Test
    void mustSaveAnOrder() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        OrdersModel ordersModel = new OrdersModel(1L,
                1L,new Date(), "PREPARACION ",
                1L, 1l);

        //When
        //Comportamiento esperado de los metodos
        when(ordersPersistencePort.saveOrders(any())).thenReturn(ordersModel);
        ordersUseCase.saveOrders(ordersModel);

        //Then
        //Se comprueba que se guarde la orden
        verify(ordersPersistencePort).saveOrders(any(OrdersModel.class));
    }

    @Test
    void mustReturnAllOrders() {
        //Given
        //Datos necesarios para el funcionamiento de los metodos
        List<OrdersModel> ordersModelList = new ArrayList<>();
        OrdersModel ordersModel = new OrdersModel(1L,
                1L,new Date(), "PREPARACION ",
                1L, 1l);

        ordersModelList.add(ordersModel);
        ordersModelList.add(ordersModel);
        ordersModelList.add(ordersModel);

        //When
        //Comportamiento esperado de los metodos
        when(ordersPersistencePort.getAllOrders()).thenReturn(ordersModelList);
        ordersUseCase.getAllOrders();

        //Then
        //Se comprueba que se obtengan todas las ordenes
        verify(ordersPersistencePort).getAllOrders();
    }
}