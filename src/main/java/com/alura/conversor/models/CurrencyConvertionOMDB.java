package com.alura.conversor.models;

public class CurrencyConvertionOMDB{
    private String baseCode;
    private String targetCode;
    private Double conversionRate;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConvertionRate() {
        return conversionRate;
    }

    public void setConvertionRate(Double convertionRate) {
        this.conversionRate = convertionRate;
    }

    @Override
    public String toString() {
        return "CurrencyConvertionOMDB [baseCode=" + baseCode + ", targetCode=" + targetCode + ", convertionRate="
                + conversionRate + "]";
    }
}