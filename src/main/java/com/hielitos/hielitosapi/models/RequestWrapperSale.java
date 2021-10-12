package com.hielitos.hielitosapi.models;

import java.util.ArrayList;

public class RequestWrapperSale {
    private SaleModel sale;
    private ArrayList<HielitoSaleModel> hielitoSales;

    public RequestWrapperSale() {
    }

    public RequestWrapperSale(SaleModel sale, ArrayList<HielitoSaleModel> hielitoSales) {
        this.sale = sale;
        this.hielitoSales = hielitoSales;
    }

    public SaleModel getSale() {
        return sale;
    }

    public void setSale(SaleModel sale) {
        this.sale = sale;
    }

    public ArrayList<HielitoSaleModel> getHielitoSales() {
        return hielitoSales;
    }

    public void setHielitoSales(ArrayList<HielitoSaleModel> hielitoSales) {
        this.hielitoSales = hielitoSales;
    }
}
