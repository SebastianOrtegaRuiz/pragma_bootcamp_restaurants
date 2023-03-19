package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.domain.spi.IRestaurantsPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.exception.NoValidNumber;
import com.pragma.restaurant.infraestructure.output.entity.RestaurantsEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IRestaurantsEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IRestaurantsRepository;
import com.pragma.restaurant.infraestructure.utilities.IUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class RestaurantsJpaAdapter implements IRestaurantsPersistencePort {
    private final IRestaurantsRepository restaurantsRepository;
    private final IRestaurantsEntityMapper restaurantsEntityMapper;

    @Override
    public RestaurantsModel saveRestaurants(@Valid RestaurantsModel restaurantsModel) {
        RestaurantsEntity restaurantsEntity = restaurantsRepository.save(restaurantsEntityMapper.toEntity(restaurantsModel));
        return restaurantsEntityMapper.toRestaurantsModel(restaurantsEntity);
    }

    @Override
    public Page<RestaurantsModel> getAllRestaurants(int pages, int records) {

        try {

            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
            orders.add(order);

            Pageable paging = PageRequest.of(pages - 1, records, Sort.by(orders));

            Page<RestaurantsModel> pageRestaurants = restaurantsRepository.findAll(paging).map(restaurantsEntityMapper::toRestaurantsModel);

            if (pageRestaurants.getContent().isEmpty()) {
                throw new NoDataFoundException();
            }

            return pageRestaurants;

        } catch (HttpStatusCodeException e) {
            return null;
        }
    }

    @Override
    public RestaurantsModel getRestaurantById(Long id) {
        RestaurantsEntity restaurantEntity = restaurantsRepository.findById(id).orElse(null);
        return restaurantsEntityMapper.toRestaurantsModel(restaurantEntity);
    }
}
