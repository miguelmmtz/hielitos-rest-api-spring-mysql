package com.hielitos.hielitosapi.repositories;

import com.hielitos.hielitosapi.models.WeekClosingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekClosingRepository extends CrudRepository<WeekClosingModel, Long> {
}
