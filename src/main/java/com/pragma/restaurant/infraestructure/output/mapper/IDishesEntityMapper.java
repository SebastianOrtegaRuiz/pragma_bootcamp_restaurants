package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishesEntityMapper {
    @Mapping(target = "restaurantsEntity", source = "restaurantsModel")
    DishesEntity toEntity(DishesModel dish);
    @Mapping(target = "restaurantsModel", source = "restaurantsEntity")
    DishesModel toDishesModel(DishesEntity dishesEntity);
    List<DishesModel> toDishesModelList(List<DishesEntity> dishesEntityList);

}
