package com.sasf.pizza.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPK implements Serializable{
    
    private Integer idOrder;
    private Integer idItem;

 @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        OrderItemPK that = (OrderItemPK) o; 
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idItem);
    }
    

}
