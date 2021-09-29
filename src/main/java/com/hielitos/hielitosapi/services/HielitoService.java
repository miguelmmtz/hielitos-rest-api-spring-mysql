package com.hielitos.hielitosapi.services;

import com.hielitos.hielitosapi.models.HielitoModel;
import com.hielitos.hielitosapi.repositories.HielitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HielitoService {
    @Autowired
    HielitoRepository hielitoRepository;

    public ArrayList<HielitoModel> getAllHielitos(){
        return (ArrayList<HielitoModel>) hielitoRepository.findAll();
    }

    public HielitoModel saveHielito(HielitoModel hielito){
        return hielitoRepository.save(hielito);
    }

    public Optional<HielitoModel> getHielitoById(Long id){
        return hielitoRepository.findById(id);
    }

    public ArrayList<HielitoModel> findByFlavour(String flavour){
        return hielitoRepository.findByFlavour(flavour);
    }

    public boolean deleteHielito(Long id){
        try {
            hielitoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
