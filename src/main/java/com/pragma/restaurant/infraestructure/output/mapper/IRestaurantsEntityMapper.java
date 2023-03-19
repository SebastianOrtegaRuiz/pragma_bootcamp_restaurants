package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.RestaurantsModel;
import com.pragma.restaurant.infraestructure.output.entity.RestaurantsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRestaurantsEntityMapper {

    RestaurantsEntity toEntity(RestaurantsModel restaurant);
    RestaurantsModel toRestaurantsModel(RestaurantsEntity restaurantsEntity);
    List<RestaurantsModel> toRestaurantsModelList(List<RestaurantsEntity> restaurantEntityList);

}
