package com.pragma.restaurant.infraestructure.configuration;

import com.pragma.restaurant.domain.api.*;
import com.pragma.restaurant.domain.spi.*;
import com.pragma.restaurant.domain.usecase.*;
import com.pragma.restaurant.domain.validations.RestaurantValidator;
import com.pragma.restaurant.infraestructure.output.adapter.*;
import com.pragma.restaurant.infraestructure.output.mapper.*;
import com.pragma.restaurant.infraestructure.output.repository.*;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import com.pragma.restaurant.infraestructure.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantsEntityMapper restaurantsEntityMapper;
    private final IRestaurantsRepository restaurantsRepository;

    private final IDishesEntityMapper dishesEntityMapper;
    private final IDishesRepository dishesRepository;

    private final IOrdersEntityMapper ordersEntityMapper;
    private final IOrdersRepository ordersRepository;

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    private final IDishes_OrdersRepository dishes_ordersRepository;
    private final IDishes_OrdersEntityMapper dishes_ordersEntityMapper;

    private final IRestaurant_EmployeeRepository restaurant_EmployeeRepository;
    private final IRestaurant_EmployeeEntityMapper restaurant_EmployeeEntityMapper;

    @Bean
    public IRestaurantsPersistencePort restaurantsPersistencePort() {
        return new RestaurantsJpaAdapter(restaurantsRepository, restaurantsEntityMapper);
    }

    @Bean
    public IRestaurantsServicePort restaurantsServicePort() {
        return new RestaurantsUseCase(restaurantsPersistencePort(), new RestaurantValidator());
    }

    @Bean
    public IDishesPersistencePort dishesPersistencePort() {
        return new DishesJpaAdapter(dishesRepository, dishesEntityMapper);
    }

    @Bean
    public IDishesServicePort dishesServicePort() {
        return new DishesUseCase(dishesPersistencePort());
    }

    @Bean
    public IOrdersPersistencePort ordersPersistencePort() {
        return new OrdersJpaAdapter(ordersRepository, ordersEntityMapper);
    }

    @Bean
    public IOrdersServicePort ordersServicePort() {
        return new OrdersUseCase(ordersPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }


    @Bean
    public IDishes_OrdersPersistencePort dishes_ordersPersistencePort() {
        return new Dishes_OrdersJpaAdapter(dishes_ordersRepository, dishes_ordersEntityMapper);
    }

    @Bean
    public IDishes_OrdersServicePort dishes_ordersServicePort() {
        return new Dishes_OrdersUseCase(dishes_ordersPersistencePort());
    }

    @Bean
    public IRestaurant_EmployeePersistencePort restaurant_EmployeePersistencePort() {
        return new Restaurant_EmployeeJpaAdapter(restaurant_EmployeeRepository, restaurant_EmployeeEntityMapper);
    }

    @Bean
    public IRestaurant_EmployeeServicePort restaurant_EmployeeServicePort() {
        return new Restaurant_EmployeeUseCase(restaurant_EmployeePersistencePort());
    }

    @Bean
    public IUtilities utility() {
        return new Utilities();
    }
}
