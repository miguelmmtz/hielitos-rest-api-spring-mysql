package com.hielitos.hielitosapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sales")
public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String location;
    private Integer quantity;
    private Double total_amount;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public SaleModel() {
    }

    public SaleModel(Long id, String location, Integer quantity, Double total_amount, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.location = location;
        this.quantity = quantity;
        this.total_amount = total_amount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getTotal_amount() { return total_amount; }

    public void setTotal_amount(Double total_amount) { this.total_amount = total_amount; }
}

