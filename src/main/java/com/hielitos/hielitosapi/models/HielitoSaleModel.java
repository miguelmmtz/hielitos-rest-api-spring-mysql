package com.hielitos.hielitosapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hielito_sale")
public class HielitoSaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_hielito")
    private HielitoModel hielito;
    private Integer quantity;
    private Double amount;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sale")
    private SaleModel sale;
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    public HielitoSaleModel() {
    }

    public HielitoSaleModel(Long id, HielitoModel hielito, Integer quantity, Double amount, SaleModel sale, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.hielito = hielito;
        this.quantity = quantity;
        this.amount = amount;
        this.sale = sale;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public HielitoModel getHielito() { return hielito; }

    public void setHielito(HielitoModel hielito) { this.hielito = hielito; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public SaleModel getSale() { return sale; }

    public void setSale(SaleModel sale) { this.sale = sale; }

    public Timestamp getCreated_at() { return created_at; }

    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }

    public Timestamp getUpdated_at() { return updated_at; }

    public void setUpdated_at(Timestamp updated_at) { this.updated_at = updated_at; }
}
