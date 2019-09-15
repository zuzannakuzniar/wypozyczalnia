package com.sda.project.wypozyczalnia.controllers;

import com.sda.project.wypozyczalnia.model.Orders;
import com.sda.project.wypozyczalnia.services.OrdersService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping()
    public Orders addNewOrders(@RequestBody Orders orders) {
        Orders savedOrders = ordersService.addNewOrders(orders);
        return savedOrders;
    }

    @GetMapping()
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrdersById(@PathVariable("id") Long id) {
        return ordersService.getOrdersById(id);
    }

    @PutMapping("/{id}")
    public Orders updateOrders(@PathVariable("id") Long id, @RequestBody Orders orders) {
        return ordersService.updateOrdersById(id, orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable("id") Long id) {
        ordersService.deleteOrdersById(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity handleObjectNotFoundException(ObjectNotFoundException onfe) {
        return ResponseEntity.notFound().build();
    }

}