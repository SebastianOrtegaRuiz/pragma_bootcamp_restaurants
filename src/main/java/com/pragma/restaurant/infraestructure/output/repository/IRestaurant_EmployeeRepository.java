package com.pragma.restaurant.infraestructure.output.repository;

import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeEntity;
import com.pragma.restaurant.infraestructure.output.entity.restaurant_employee.Restaurant_EmployeeId;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IRestaurant_EmployeeRepository extends JpaRepository<Restaurant_EmployeeEntity, Restaurant_EmployeeId> {

    interface Resp {
        Long getid_restaurant();
        Long getid_person();
        String getfield();
    }

    @Query(value="SELECT id_restaurant,id_person,field FROM restaurant_employee WHERE id_person = :id_person and id_restaurant = :id_restaurant",
            nativeQuery = true)
    Resp findByid_person(@Param("id_person") Long id_person, @Param("id_restaurant") Long id_restaurant);

    @Query(value="SELECT id_restaurant,id_person,field FROM restaurant_employee WHERE id_person = :id_person",
            nativeQuery = true)
    Resp findById(@Param("id_person") Long id_person);

}
