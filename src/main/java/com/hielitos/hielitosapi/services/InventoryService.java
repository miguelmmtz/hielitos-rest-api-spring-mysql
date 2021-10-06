package com.hielitos.hielitosapi.services;

import com.hielitos.hielitosapi.models.HielitoModel;
import com.hielitos.hielitosapi.models.InventoryModel;
import com.hielitos.hielitosapi.repositories.HielitoRepository;
import com.hielitos.hielitosapi.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    HielitoRepository hielitoRepository;


    public ArrayList<InventoryModel> getAllInventories(){
        return (ArrayList<InventoryModel>) inventoryRepository.findAll();
    }

    public InventoryModel saveInventory(InventoryModel inventory){
        Optional<HielitoModel> hielito = hielitoRepository.findById(inventory.getHielito().getId());
        if(hielito.isPresent()){
            HielitoModel hielitoPresent = hielito.get();
            hielitoPresent.setStock(hielitoPresent.getStock() + inventory.getQuantity());
            hielitoRepository.save(hielitoPresent);
        }
        return inventoryRepository.save(inventory);
    }

    public Optional<InventoryModel> getInventoryById(Long id){
        return inventoryRepository.findById(id);
    }

    public boolean deleteInventory(Long id){
        try {
            InventoryModel inventory = inventoryRepository.findById(id).orElse(null);
            HielitoModel hielito = hielitoRepository.findById(inventory.getHielito().getId()).orElse(null);
            Objects.requireNonNull(hielito).setStock(hielito.getStock() - inventory.getQuantity());
            inventoryRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
