package com.hielitos.hielitosapi.repositories;

import com.hielitos.hielitosapi.models.HielitoSaleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface HielitoSaleRepository extends CrudRepository<HielitoSaleModel, Long> {
    @Query(value = "SELECT hs FROM HielitoSaleModel hs WHERE hs.sale.id = :id")
    //@Query(value = "SELECT * FROM hielito_sale WHERE id_sale = :id", nativeQuery = true)
    ArrayList<HielitoSaleModel> findAllBySaleId(@Param(value = "id") Long id);
}
