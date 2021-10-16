package com.hielitos.hielitosapi.services;

import com.hielitos.hielitosapi.models.RequestWrapperWeekClosing;
import com.hielitos.hielitosapi.models.WeekClosingModel;
import com.hielitos.hielitosapi.repositories.HielitoClosingRepository;
import com.hielitos.hielitosapi.repositories.WeekClosingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WeekClosingService {
    @Autowired
    WeekClosingRepository weekClosingRepository;
    @Autowired
    HielitoClosingRepository hielitoClosingRepository;

    public ArrayList<WeekClosingModel> getAllWeekClosing(){
        return (ArrayList<WeekClosingModel>) weekClosingRepository.findAll();
    }

    public boolean saveWeekClosing(RequestWrapperWeekClosing requestWrapperWeekClosing){
        WeekClosingModel weekClosing = requestWrapperWeekClosing.getWeekClosing();
        weekClosingRepository.save(weekClosing);
        requestWrapperWeekClosing.getHielitoClosings().forEach(hc -> {
            hc.setWeekClosing(weekClosing);
            hielitoClosingRepository.save(hc);
        });
        return true;
    }

    public Optional<RequestWrapperWeekClosing> getWeekClosingById(Long id){
        RequestWrapperWeekClosing requestWrapperWeekClosing = new RequestWrapperWeekClosing();
        Optional<WeekClosingModel> weekClosing = weekClosingRepository.findById(id);
        if(weekClosing.isPresent()){
          WeekClosingModel weekClosingPresent = weekClosing.get();
          requestWrapperWeekClosing.setWeekClosing(weekClosingPresent);
          requestWrapperWeekClosing.setHielitoClosings(hielitoClosingRepository.findAllByWeekClosingId(id));
        }
        return Optional.of(requestWrapperWeekClosing);
    }

    public boolean deleteWeekClosing(Long id){
        try {
            Optional<RequestWrapperWeekClosing> requestWrapperWeekClosing = getWeekClosingById(id);
            if(requestWrapperWeekClosing.isPresent()){
                RequestWrapperWeekClosing requestWrapperWeekClosingPresent = requestWrapperWeekClosing.get();
                requestWrapperWeekClosingPresent.getHielitoClosings().forEach(hc -> hielitoClosingRepository.delete(hc));
                weekClosingRepository.delete(requestWrapperWeekClosingPresent.getWeekClosing());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
