package com.hielitos.hielitosapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hielito_sale")
public class HielitoSaleModel extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;
    private Integer quantity;
    private Double amount;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sale")
    private SaleModel sale;

}
