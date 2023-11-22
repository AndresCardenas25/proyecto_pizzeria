package com.sasf.pizza.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasf.pizza.persistence.entity.CustomerEntity;
import com.sasf.pizza.persistence.entity.OrderEntity;
import com.sasf.pizza.service.CustomerService;
import com.sasf.pizza.service.OrderService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    public final CustomerService customerService;
    public final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService){
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> getByPhone(@PathVariable String phone){
        return ResponseEntity.ok(customerService.findByPhone(phone));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable String id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }    

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String id){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerEntity customer){
        customerService.createCustomer(customer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerEntity customer){
        customerService.updateCustomer(customer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
