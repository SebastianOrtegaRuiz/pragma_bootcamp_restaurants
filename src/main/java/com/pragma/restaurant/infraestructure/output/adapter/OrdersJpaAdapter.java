package com.pragma.restaurant.infraestructure.output.adapter;

import com.pragma.restaurant.domain.model.OrdersModel;
import com.pragma.restaurant.domain.spi.IOrdersPersistencePort;
import com.pragma.restaurant.infraestructure.exception.NoDataFoundException;
import com.pragma.restaurant.infraestructure.output.entity.OrdersEntity;
import com.pragma.restaurant.infraestructure.output.mapper.IOrdersEntityMapper;
import com.pragma.restaurant.infraestructure.output.repository.orders.IOrdersRepository;
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
public class OrdersJpaAdapter implements IOrdersPersistencePort {
    private final IOrdersRepository ordersRepository;
    private final IOrdersEntityMapper ordersEntityMapper;

    @Override
    public OrdersModel saveOrders(@Valid OrdersModel ordersModel) {
        OrdersEntity ordersEntity = ordersRepository.save(ordersEntityMapper.toEntity(ordersModel));
        if(ordersEntity == null) {
            throw new NoDataFoundException();
        }
        return ordersEntityMapper.toOrdersModel(ordersEntity);
    }

    @Override
    public OrdersModel updateOrders(OrdersModel ordersModel) {
        OrdersEntity ordersEntity = ordersRepository.save(ordersEntityMapper.toEntity(ordersModel));
        if(ordersEntity == null) {
            throw new NoDataFoundException();
        }
        return ordersEntityMapper.toOrdersModel(ordersEntity);
    }

    @Override
    public Page<OrdersModel> getAllOrders(int pages, int records, String status) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();

            Sort.Order order = new Sort.Order(Sort.Direction.ASC, "id");
            orders.add(order);

            Pageable paging = PageRequest.of(pages - 1, records, Sort.by(orders));

            Page<OrdersModel> pageOrders = ordersRepository.findByStatus(status, paging).map(ordersEntityMapper::toOrdersPageModel);

            if (pageOrders.getContent().isEmpty()) {
                throw new NoDataFoundException();
            }

            return pageOrders;

        } catch (HttpStatusCodeException e) {
            return null;
        }
    }

    @Override
    public List<OrdersModel> getOrdersByClientAndStatus(Long id) {
        return ordersEntityMapper.toOrdersModeResplList(ordersRepository.findByClientAndStatus(id));
    }

    @Override
    public OrdersModel getOrdersById(Long id) {
        return ordersEntityMapper.toOrdersModel(ordersRepository.findById(id).orElse(null));
    }
}
