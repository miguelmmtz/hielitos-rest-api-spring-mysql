package com.hielitos.hielitosapi.controllers;


import com.hielitos.hielitosapi.models.InventoryModel;
import com.hielitos.hielitosapi.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public ArrayList<InventoryModel> getAllInventory() {
        return inventoryService.getAllInventories();
    }

    @PostMapping
    public InventoryModel saveInventory(@RequestBody InventoryModel inventory) {
        return this.inventoryService.saveInventory(inventory);
    }

    @GetMapping("/{id}")
    public Optional<InventoryModel> getInventoryById(@PathVariable("id") Long id){
        return this.inventoryService.getInventoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return this.inventoryService.deleteInventory(id) ? "Se ha borrado el inventario "+id : "No se pudo eliminar el inventario "+id;
    }
}
