package com.alura.conversor.models;

import javax.swing.SortingFocusTraversalPolicy;

public class CurrencyConvertion {
    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private Double convertion;

    public CurrencyConvertion() {

    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getConvertion() {
        return convertion;
    }

    public void setConvertion(Double convertion) {
        this.convertion = convertion * this.amount;
    }

    @Override
    public String toString() {
        return "$" + this.amount + " " + this.fromCurrency + " son $" + this.convertion + " " + this.toCurrency;
    }
}