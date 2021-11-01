package com.hielitos.hielitosapi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory")
public class InventoryModel extends BaseModel{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;
    private Integer quantity;
    private Double estimated_benefit;

}

