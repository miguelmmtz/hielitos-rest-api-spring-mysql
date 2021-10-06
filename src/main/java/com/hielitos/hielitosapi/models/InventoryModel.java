package com.hielitos.hielitosapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;

    private Integer quantity;
    private Double estimated_benefit;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public InventoryModel() {
    }

    public InventoryModel(Long id, HielitoModel hielito, Integer quantity, Double estimated_benefit, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.hielito = hielito;
        this.quantity = quantity;
        this.estimated_benefit = estimated_benefit;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public HielitoModel getHielito() { return hielito; }

    public void setHielito(HielitoModel hielito) { this.hielito = hielito; }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getEstimated_benefit() {
        return estimated_benefit;
    }

    public void setEstimated_benefit(Double estimated_benefit) {
        this.estimated_benefit = estimated_benefit;
    }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}

