package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    interface categories {
        String getname();
        String getdescription();
        String getdischesname();

        String getrestaurantsId();
    }

    @Query(value="SELECT c.name, c.description, d.name as dischesname FROM category c" +
            " INNER JOIN dishes d ON c.id = d.id_category" +
            " INNER JOIN restaurants r ON d.id_restaurant = r.id" +
            " WHERE r.id = 1 AND active = 1 #{#pageable}",
            countQuery = "SELECT count(*) FROM category" +
                    " INNER JOIN dishes ON category.id = dishes.id_category" +
                    " INNER JOIN restaurants ON dishes.id_restaurant = restaurants.id" +
                    " WHERE restaurants.id = 1 AND active = 1",
            nativeQuery = true)
    Page<categories> findAllByRestaurant(Pageable pageable);

}
