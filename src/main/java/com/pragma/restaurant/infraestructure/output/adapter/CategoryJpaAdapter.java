package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.CategoryByRestaurantsModel;
import com.pragma.restaurant.domain.model.CategoryModel;
import com.pragma.restaurant.domain.spi.ICategoryPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import com.pragma.restaurant.infraestructure.output.mapper.ICategoryEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.HttpStatusCodeException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public CategoryModel saveCategory(@Valid CategoryModel categoryModel) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryEntityMapper.toEntity(categoryModel));
        if(categoryEntity == null) {
            throw new NoDataFoundException();
        }
        return categoryEntityMapper.toCategoryModel(categoryEntity);
    }

    @Override
    public Page<CategoryModel> getAllCategory(int page, int records) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
            orders.add(order);

            Pageable paging = PageRequest.of(page - 1, records, Sort.by(orders));

            System.out.println(categoryRepository.findAll(paging));

            Page<CategoryModel> pageCategory = categoryRepository.findAll(paging).map(categoryEntityMapper::toCategoryModel);
            if (pageCategory.getContent().isEmpty()) {
                throw new NoDataFoundException();
            }
            return pageCategory;
        } catch (HttpStatusCodeException e) {
            return null;
        }
    }

    @Override
    public Page<CategoryByRestaurantsModel> getAllCategoryByRestauran() {
        try {

            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
            orders.add(order);

            Pageable paging = PageRequest.of(1, 5, Sort.by(orders));

            Page<CategoryByRestaurantsModel> pageCategory = categoryRepository.findAllByRestaurant(paging).map(categoryEntityMapper::toCategoryIdModel);

            if (pageCategory.getContent().isEmpty()) {
                throw new NoDataFoundException();
            }

            return pageCategory;
        } catch (HttpStatusCodeException e) {
            return null;
        }
    }
}
