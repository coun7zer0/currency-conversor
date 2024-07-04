package com.alura.conversor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.alura.conversor.interfaces.InputDialogMultiple;
import com.google.inject.internal.util.Lists;

public class App
{
    public static void main( String[] args )
    {
        List<Object> conversionMenu = Lists.newArrayList("Conversor de Moneda", "Conversor de Temperatura");

        InputDialogMultiple DialogMultiple = new InputDialogMultiple(conversionMenu, "Ingresa una opción de conversión");

        String option = DialogMultiple.show();

        if (option.contentEquals("Conversor de Moneda")) {
            currencyConvertion();
        } else {
            temperatureConvertion();
        }
    }

    public static void currencyConvertion() {
        Double amount = null;

        Map<String, String> currencies = new HashMap<>();
        currencies.put("Pesos Mexicanos", "MXN");
        currencies.put("Dólar Estadounidenses", "USD");
        currencies.put("Euro", "EUR");
        currencies.put("Libras Esterlinas", "GBP");
        currencies.put("Yen Japonés", "JPY");
        currencies.put("Won Sul-Coreano", "KRW");

        while (amount == null ) {
            try {
                amount =  Double.valueOf(JOptionPane.showInputDialog(null, "Ingrsa la cantidad de dinero que desea convertir:", null, JOptionPane.QUESTION_MESSAGE));
                if (amount < 0) {
                    amount = null;
                    throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
                }
                   } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            }
        }

        List<String> currencyList = new ArrayList<>(currencies.keySet());
        InputDialogMultiple fromCurrencyMenu = new InputDialogMultiple(currencyList, "¿Desde que moneda desea convertir?");
        String fromCurrency = fromCurrencyMenu.show();

        InputDialogMultiple toCurrencyManu = new InputDialogMultiple(currencyList.stream()
                                                                     .filter(opt -> !opt.equals(fromCurrency))
                                                                     .collect(Collectors.toList()),
                                                                     "¿A que moneda quiere convertir?");
        String toCurrency = toCurrencyManu.show();
            }

    public static void temperatureConvertion() {

    }
}
