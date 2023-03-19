package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.DishesModel;
import com.pragma.restaurant.domain.spi.IDishesPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.DishesEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IDishesEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.IDishesRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class DishesJpaAdapter implements IDishesPersistencePort {
    private final IDishesRepository dishesRepository;
    private final IDishesEntityMapper dishesEntityMapper;

    @Override
    public DishesModel saveDishes(@Valid DishesModel dishesModel) {
        DishesEntity dishesEntity = dishesRepository.save(dishesEntityMapper.toEntity(dishesModel));
        if(dishesEntity == null) {
            throw new NoDataFoundException();
        }
        return dishesEntityMapper.toDishesModel(dishesEntity);
    }

    @Override
    public DishesModel updateDishes(DishesModel dishesModel) {
        DishesEntity dishesEntity = dishesRepository.save(dishesEntityMapper.toEntity(dishesModel));
        if(dishesEntity == null) {
            throw new NoDataFoundException();
        }
        return dishesEntityMapper.toDishesModel(dishesEntity);
    }

    @Override
    public DishesModel changeStatusDishes(DishesModel dishesModel) {
        DishesEntity dishesEntity = dishesRepository.save(dishesEntityMapper.toEntity(dishesModel));
        if(dishesEntity == null) {
            throw new NoDataFoundException();
        }
        return dishesEntityMapper.toDishesModel(dishesEntity);
    }

    @Override
    public List<DishesModel> getAllDishes() {
        List<DishesEntity> entityList = dishesRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return dishesEntityMapper.toDishesModelList(entityList);
    }

    @Override
    public DishesModel getDishesById(Long id) {
        DishesEntity entityList = dishesRepository.findById(id).orElse(null);
        return dishesEntityMapper.toDishesModel(entityList);
    }
}
