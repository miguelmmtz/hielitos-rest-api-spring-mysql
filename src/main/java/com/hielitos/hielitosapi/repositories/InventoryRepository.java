package com.hielitos.hielitosapi.repositories;

import com.hielitos.hielitosapi.models.InventoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends CrudRepository<InventoryModel, Long> {
}
