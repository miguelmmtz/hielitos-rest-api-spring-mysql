package com.hielitos.hielitosapi.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_hielito")
public class HielitoModel extends BaseModel {

    private String flavour;
    private Double price;
    private Integer stock;

}

