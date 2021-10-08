package com.hielitos.hielitosapi.services;

import com.hielitos.hielitosapi.models.SaleModel;
import com.hielitos.hielitosapi.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public ArrayList<SaleModel> getAllSales(){
        return (ArrayList<SaleModel>) saleRepository.findAll();
    }

    public SaleModel saveSale(SaleModel sale){
        return saleRepository.save(sale);
    }

    public Optional<SaleModel> getSaleById(Long id){
        return saleRepository.findById(id);
    }

    public boolean deleteSale(Long id){
        try {
            saleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
