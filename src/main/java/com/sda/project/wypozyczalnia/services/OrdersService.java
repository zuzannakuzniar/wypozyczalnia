package com.sda.project.wypozyczalnia.services;

import com.google.common.collect.Lists;
import com.sda.project.wypozyczalnia.dao.OrdersRepository;
import com.sda.project.wypozyczalnia.model.Orders;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersService {

    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders addNewOrders(Orders orders) {
        return ordersRepository.save(createNewOrders(orders));
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Orders.class.getName()));
            }

    public List<Orders> getAllOrders() {
        return Lists.newArrayList(ordersRepository.findAll());
    }

    public Orders deleteOrdersById (Long id) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Orders.class.getName()));

        ordersRepository.deleteById(id);
        return orders;
    }

    public Orders updateOrdersById(Long id, Orders orders) {
        Orders foundOrders = ordersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Orders.class.getName()));

        foundOrders.setSummary(orders.getSummary());

        return ordersRepository.save(foundOrders);
    }

    private Orders createNewOrders(Orders orders) {

        Orders result = new Orders();
        result.setSummary(orders.getSummary());

        return result;
    }
}


