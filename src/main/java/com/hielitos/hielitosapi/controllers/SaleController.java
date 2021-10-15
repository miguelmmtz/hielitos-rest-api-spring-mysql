package com.hielitos.hielitosapi.controllers;

import com.hielitos.hielitosapi.models.RequestWrapperSale;
import com.hielitos.hielitosapi.models.SaleModel;
import com.hielitos.hielitosapi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
    public String saveSale(@RequestBody RequestWrapperSale requestWrapperSale){
        return this.saleService.saveSale(requestWrapperSale) ? "Exitoso" : "Algo salio mal";
    }

    @GetMapping("/{id}")
    public Optional<RequestWrapperSale> getSaleById(@PathVariable("id") Long id){
        return this.saleService.getSaleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSaleById(@PathVariable("id") Long id){
        return this.saleService.deleteSale(id) ? "Se ha borrado la venta "+id : "No se pudo eliminar la venta "+id;
    }
}
