package com.sasf.pizza.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sasf.pizza.persistence.entity.PizzaEntity;
import com.sasf.pizza.service.PizzaService;
import com.sasf.pizza.service.dto.UpdatePizzaPriceDto;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController( PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page, 
                                                    @RequestParam (defaultValue = "8")int elements){
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @GetMapping("/available")
    public ResponseEntity<Page<PizzaEntity>> getAvailablePizza(@RequestParam(defaultValue = "0") int page, 
                                                               @RequestParam (defaultValue = "8")int elements,
                                                               @RequestParam (defaultValue = "price")String sortBy,
                                                               @RequestParam (defaultValue = "ASC")String sortDirection){
        return ResponseEntity.ok(this.pizzaService.getAvailablePizzas(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/ingredient/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getByIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getByIngredient(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getByWithoutIngredient(@PathVariable String ingredient){
        return ResponseEntity.ok(this.pizzaService.getByWithoutIngredient(ingredient));
    }

    @GetMapping("cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapestPizzas(@PathVariable double price){
        return ResponseEntity.ok(this.pizzaService.getCheapest(price));
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable int idPizza){
        return ResponseEntity.ok(pizzaService.getById(idPizza));
    }

    @PostMapping("/save")
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizza){
        if (pizza.getIdPizza() == null || this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(pizzaService.save(pizza));
        } 
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if (pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(pizzaService.save(pizza));
        } 
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto dto){
        if (this.pizzaService.exists(dto.getPizzaId())){
            this.pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        } 
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idPizza}")
    public ResponseEntity<Void>delete(@PathVariable int idPizza){
        if(this.pizzaService.exists(idPizza)){
            this.pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        } 
        return ResponseEntity.badRequest().build();
    }




}
