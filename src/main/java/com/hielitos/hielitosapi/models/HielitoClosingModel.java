package com.hielitos.hielitosapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hielito_closing")
public class HielitoClosingModel extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;
    private Integer quantity;
    private Double benefit;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_weekclosing")
    private WeekClosingModel weekClosing;

}
