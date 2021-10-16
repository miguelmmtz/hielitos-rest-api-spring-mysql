package com.hielitos.hielitosapi.models;

import java.util.ArrayList;

public class RequestWrapperWeekClosing {
    private WeekClosingModel weekClosing;
    private ArrayList<HielitoClosingModel> hielitoClosings;

    public RequestWrapperWeekClosing() {
    }

    public RequestWrapperWeekClosing(WeekClosingModel weekClosing, ArrayList<HielitoClosingModel> hielitoClosings) {
        this.weekClosing = weekClosing;
        this.hielitoClosings = hielitoClosings;
    }

    public WeekClosingModel getWeekClosing() { return weekClosing; }

    public void setWeekClosing(WeekClosingModel weekClosing) { this.weekClosing = weekClosing; }

    public ArrayList<HielitoClosingModel> getHielitoClosings() { return hielitoClosings; }

    public void setHielitoClosings(ArrayList<HielitoClosingModel> hielitoClosings) { this.hielitoClosings = hielitoClosings; }
}
