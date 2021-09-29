package com.hielitos.hielitosapi.repositories;

import com.hielitos.hielitosapi.models.HielitoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HielitoRepository extends CrudRepository<HielitoModel, Long> {
    public abstract ArrayList<HielitoModel> findByFlavour(String flavour);
}
