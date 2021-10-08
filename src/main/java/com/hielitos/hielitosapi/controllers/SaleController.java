package com.hielitos.hielitosapi.controllers;

import com.hielitos.hielitosapi.models.SaleModel;
import com.hielitos.hielitosapi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping
    public ArrayList<SaleModel> getAllSales(){
        return saleService.getAllSales();
    }

    @PostMapping
    public SaleModel saveSale(@RequestBody SaleModel sale){
        return this.saleService.saveSale(sale);
    }

    @DeleteMapping("/{id}")
    public String deleteSaleById(@PathVariable("id") Long id){
        return this.saleService.deleteSale(id) ? "Se ha borrado la venta con id "+id : "No se pudo eliminar la venta con id "+id;
    }
}
