package com.pragma.restaurant.infraestructure.output.repository.orders;

import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrdersRepository extends JpaRepository<OrdersEntity, Long> {



    @Query(value="SELECT id,id_client,date,status,id_chef,id_restaurant from orders " +
                  "where id_Client = :id and status in ('en_preparacion','pendiente','listo')",
            nativeQuery = true)
    List<IOrdersResponseRepository> findByClientAndStatus(@Param("id") Long id);

    @Query(value="SELECT id,id_client,date,status,id_chef,id_restaurant from orders " +
            "where status = :status",
            countQuery = "SELECT COUNT(*) from orders" +
                         " where status = :status",
            nativeQuery = true)
    Page<IOrdersResponseRepository> findByStatus(@Param("status") String status, Pageable pageable);
}
