package com.hielitos.hielitosapi.controllers;

import com.hielitos.hielitosapi.models.HielitoModel;
import com.hielitos.hielitosapi.services.HielitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/hielitos")
public class HielitoController {
    @Autowired
    HielitoService hielitoService;

    @GetMapping()
    public ArrayList<HielitoModel> getAllHielitos(){
        return hielitoService.getAllHielitos();
    }

    @PostMapping()
    public HielitoModel saveHielito(@RequestBody HielitoModel hielito){
        return this.hielitoService.saveHielito(hielito);
    }

    @GetMapping(path = "/{id}")
    public Optional<HielitoModel> getHielitoById(@PathVariable("id") Long id){
        return this.hielitoService.getHielitoById(id);
    }

    @GetMapping("/query")
    public ArrayList<HielitoModel> findByFlavour(@RequestParam("flavour") String flavour){
        return this.hielitoService.findByFlavour(flavour);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        return this.hielitoService.deleteHielito(id) ? "Se ha borrado el hielito con id "+id : "No se pudo eliminar el hielito con id "+id;
    }
}
