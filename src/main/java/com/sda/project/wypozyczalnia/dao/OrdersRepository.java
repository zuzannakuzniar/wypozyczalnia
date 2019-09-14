package com.sda.project.wypozyczalnia.dao;

import com.sda.project.wypozyczalnia.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
