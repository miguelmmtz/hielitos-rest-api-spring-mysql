package com.hielitos.hielitosapi.controllers;

import com.hielitos.hielitosapi.models.RequestWrapperWeekClosing;
import com.hielitos.hielitosapi.models.WeekClosingModel;
import com.hielitos.hielitosapi.services.WeekClosingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/weekclosing")
public class WeekClosingController {
    @Autowired
    WeekClosingService weekClosingService;

    @GetMapping
    public ArrayList<WeekClosingModel> getAllWeekClosings(){
        return weekClosingService.getAllWeekClosing();
    }

    @PostMapping
    public String saveWeekClosing(@RequestBody RequestWrapperWeekClosing requestWrapperWeekClosing){
        return this.weekClosingService.saveWeekClosing(requestWrapperWeekClosing) ? "Exitoso" : "Algo salio mal";
    }

    @GetMapping("/{id}")
    public Optional<RequestWrapperWeekClosing> getWeekClosingById(@PathVariable("id") Long id){
        return this.weekClosingService.getWeekClosingById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteWeekClosing(@PathVariable("id") Long id){
        return this.weekClosingService.deleteWeekClosing(id) ? "Se ha borrado el cierre "+id : "No se pudo eliminar el cierre "+id;
    }
}
