package com.sasf.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasf.pizza.persistence.entity.CustomerEntity;
import com.sasf.pizza.persistence.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }

    public void createCustomer(CustomerEntity customerEntity){
        this.customerRepository.crudCustomer("INSERT", 
                                                    customerEntity.getIdCustomer(), 
                                                    customerEntity.getName(), 
                                                    customerEntity.getAddress(),
                                                    customerEntity.getEmail(), 
                                                    customerEntity.getPhoneNumber());
    }

    public void updateCustomer(CustomerEntity customerEntity){
        this.customerRepository.crudCustomer("UPDATE", 
                                                    customerEntity.getIdCustomer(), 
                                                    customerEntity.getName(), 
                                                    customerEntity.getAddress(),
                                                    customerEntity.getEmail(), 
                                                    customerEntity.getPhoneNumber());
    }

    public CustomerEntity getCustomerById(String idCustomer){
        return this.customerRepository.selectCustomerById(idCustomer);
    }

    @Transactional
    public void deleteCustomerById(String idCustomer){
        this.customerRepository.deleteCustomerById(idCustomer);
    }

}
