package com.sasf.pizza.persistence.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditableEntity {
    
    @Column(name = "created_by")
    @CreatedBy
    private String creadoPor;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime fechaHoraCreacion;
    
    @Column(name = "modified_by")
    @LastModifiedBy
    private String ultimaActualizacionPor;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime fechaHoraUltimaActualizacion;
}
