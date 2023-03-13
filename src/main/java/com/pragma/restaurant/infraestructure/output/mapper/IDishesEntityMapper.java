package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishesEntityMapper {

    DishesEntity toEntity(DishesModel dish);
    DishesModel toDishesModel(DishesEntity dishesEntity);
    List<DishesModel> toDishesModelList(List<DishesEntity> dishesEntityList);

}
