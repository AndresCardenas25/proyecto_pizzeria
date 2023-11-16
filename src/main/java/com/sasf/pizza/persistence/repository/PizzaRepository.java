package com.sasf.pizza.persistence.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.sasf.pizza.persistence.entity.PizzaEntity;
import com.sasf.pizza.service.dto.UpdatePizzaPriceDto;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    
    List<PizzaEntity> findAllByAvailableTrueAndDescripcionContainingIgnoreCase(String descripcion);

    List<PizzaEntity> findAllByAvailableTrueAndDescripcionNotContainingIgnoreCase(String descripcion);

    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    
    int countByVeganTrue();

    
    @Query(value = "UPDATE pizza SET price = :#{#newPizzaPrice.newPrice} WHERE id_pizza = :#{#newPizzaPrice.pizzaId} ", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
}
