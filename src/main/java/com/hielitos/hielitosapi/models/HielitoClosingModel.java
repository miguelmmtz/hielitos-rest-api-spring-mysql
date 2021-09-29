package com.hielitos.hielitosapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hielito_closing")
public class HielitoClosingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;
    private Integer quantity;
    private Double benefit;
    @ManyToOne
    @JoinColumn(name = "id_weekclosing")
    private WeekClosingModel weekClosing;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public HielitoClosingModel() {
    }

    public HielitoClosingModel(Long id, HielitoModel hielito, Integer quantity, Double benefit, WeekClosingModel weekClosing, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.hielito = hielito;
        this.quantity = quantity;
        this.benefit = benefit;
        this.weekClosing = weekClosing;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public HielitoModel getHielito() { return hielito; }

    public void setHielito(HielitoModel hielito) { this.hielito = hielito; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getBenefit() { return benefit; }

    public void setBenefit(Double benefit) { this.benefit = benefit; }

    public WeekClosingModel getWeekClosing() { return weekClosing; }

    public void setWeekClosing(WeekClosingModel weekClosing) { this.weekClosing = weekClosing; }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
