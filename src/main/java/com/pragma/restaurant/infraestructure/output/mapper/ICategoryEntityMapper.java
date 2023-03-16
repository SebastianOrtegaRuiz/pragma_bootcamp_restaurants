package com.pragma.restaurant.infraestructure.output.mapper;

import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring"
)
public interface ICategoryEntityMapper {

    @Mapping(target = "dishesEntity", source = "dishesModel")
    CategoryEntity toEntity(CategoryModel category);
    @Mapping(target = "dishesModel", source = "dishesEntity")
    CategoryModel toCategoryModel(CategoryEntity categoryEntity);
    List<CategoryModel> toCategoryModelList(List<CategoryEntity> categoryEntityList);
}
