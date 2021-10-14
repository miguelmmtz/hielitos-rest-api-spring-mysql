package com.hielitos.hielitosapi.services;

import com.hielitos.hielitosapi.models.HielitoModel;
import com.hielitos.hielitosapi.models.HielitoSaleModel;
import com.hielitos.hielitosapi.models.RequestWrapperSale;
import com.hielitos.hielitosapi.models.SaleModel;
import com.hielitos.hielitosapi.repositories.HielitoRepository;
import com.hielitos.hielitosapi.repositories.HielitoSaleRepository;
import com.hielitos.hielitosapi.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    HielitoSaleRepository hielitoSaleRepository;
    @Autowired
    HielitoRepository hielitoRepository;

    public ArrayList<SaleModel> getAllSales(){ return (ArrayList<SaleModel>) saleRepository.findAll();}

    public boolean saveSale(RequestWrapperSale requestWrapperSale){
        SaleModel sale = requestWrapperSale.getSale();
        saleRepository.save(sale);

        requestWrapperSale.getHielitoSales().forEach(h -> {
            hielitoSaleRepository.save(h);
            Optional<HielitoModel> hielito = hielitoRepository.findById(h.getHielito().getId());
            if(hielito.isPresent()){
                HielitoModel hielitoPresent = hielito.get();
                hielitoPresent.setStock(hielitoPresent.getStock() - h.getQuantity());
                hielitoRepository.save(hielitoPresent);
            }
        });
        return true;
    }

    public Optional<RequestWrapperSale> getSaleById(Long id){
        RequestWrapperSale requestWrapperSale = new RequestWrapperSale();
        Optional<SaleModel> sale = saleRepository.findById(id);
        if(sale.isPresent()){
            SaleModel salePresent = sale.get();
            requestWrapperSale.setSale(salePresent);
        }
        return Optional.of(requestWrapperSale);
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
