package com.hielitos.hielitosapi.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sales")
public class SaleModel extends BaseModel{

    private String location;
    private Integer quantity;
    private Double total_amount;

}

