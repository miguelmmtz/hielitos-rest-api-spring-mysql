package com.hielitos.hielitosapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "weekly_closing")
public class WeekClosingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private Long id;
    private Integer quantity;
    private Double benefit;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public WeekClosingModel() {
    }

    public WeekClosingModel(Long id, Integer quantity, Double benefit, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.quantity = quantity;
        this.benefit = benefit;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getBenefit() { return benefit; }

    public void setBenefit(Double benefit) { this.benefit = benefit; }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }
}
