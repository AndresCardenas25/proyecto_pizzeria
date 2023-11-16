package com.sasf.pizza.persistence.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.sasf.pizza.persistence.entity.CustomerEntity;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String>{

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")
    CustomerEntity findByPhone(@Param("phone") String phone);

    @Query(value = "SELECT * FROM customer_insert_update(:operacion, :id_customer_param, :address_param, :email_param, :name_param, :phone_number_param)", nativeQuery = true)
    void crudCustomer(
                                @Param("operacion") String operacion,
                                @Param("id_customer_param") String idCustomer,
                                @Param("name_param") String name,
                                @Param("address_param") String address,
                                @Param("email_param") String email,
                                @Param("phone_number_param") String phoneNumber);

    @Query(value = "SELECT * FROM select_customer_by_id(:idCustomer)", nativeQuery = true)
    CustomerEntity selectCustomerById(@Param("idCustomer") String idCustomer);

    @Modifying
    @Procedure(value = "delete_customer_by_id")
    void deleteCustomerById(@Param("idCustomer") String idCustomer);
                            
}
