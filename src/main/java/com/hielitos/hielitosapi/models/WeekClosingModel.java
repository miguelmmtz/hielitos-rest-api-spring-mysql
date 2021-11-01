package com.hielitos.hielitosapi.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "weekly_closing")
public class WeekClosingModel extends BaseModel {

    private Integer quantity;
    private Double benefit;

}
