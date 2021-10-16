package com.hielitos.hielitosapi.repositories;

import com.hielitos.hielitosapi.models.HielitoClosingModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HielitoClosingRepository extends CrudRepository<HielitoClosingModel, Long> {
    @Query(value = "SELECT hc FROM HielitoClosingModel hc WHERE hc.weekClosing.id = :id")
    ArrayList<HielitoClosingModel> findAllByWeekClosingId(@Param(value = "id") Long id);
}
