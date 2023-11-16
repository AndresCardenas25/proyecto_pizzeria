package com.sasf.pizza.persistence.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sasf.pizza.persistence.entity.PizzaEntity;

public interface PizzaPagSortRepository extends PagingAndSortingRepository <PizzaEntity, Integer>{
    
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
    
}
