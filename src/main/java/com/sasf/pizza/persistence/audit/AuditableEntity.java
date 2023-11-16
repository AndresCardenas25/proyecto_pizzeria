package com.sasf.pizza.persistence.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass

public abstract class AuditableEntity {
    
    @CreatedBy
    protected String creadoPor;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime fechaHoraCreacion;

    @LastModifiedBy
    protected String ultimaActualizacionPor;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime fechaHoraUltimaActualizacion;
}
