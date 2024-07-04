package com.alura.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import com.alura.conversor.interfaces.InputDialogMultiple;
import com.alura.conversor.models.CurrencyConvertion;
import com.alura.conversor.models.CurrencyConvertionOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App
{
    public static void main( String[] args )
    {
        Boolean repeat = true;
        while (repeat) {

            Double amount = null;
            CurrencyConvertion currencyConvertion = new CurrencyConvertion();
            String url = "https://v6.exchangerate-api.com/v6/cc096510a57db19438f7afdc/pair/";
            Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

            Map<String, String> currencies = new HashMap<>();
            currencies.put("Pesos Mexicanos", "MXN");
            currencies.put("Dólares Estadounidenses", "USD");
            currencies.put("Euros", "EUR");
            currencies.put("Libras Esterlinas", "GBP");
            currencies.put("Yenes Japoneses", "JPY");
            currencies.put("Wones Sul-Coreanos", "KRW");

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
            currencyConvertion.setAmount(amount);

            List<String> currencyList = new ArrayList<>(currencies.keySet());
            InputDialogMultiple fromCurrencyMenu = new InputDialogMultiple(currencyList, "¿Desde que moneda desea convertir?");
            currencyConvertion.setFromCurrency(fromCurrencyMenu.show());

            InputDialogMultiple toCurrencyManu = new InputDialogMultiple(currencyList.stream()
                                                                         .filter(opt -> !opt.equals(currencyConvertion.getFromCurrency()))
                                                                         .collect(Collectors.toList()),
                                                                         "¿A que moneda quiere convertir?");
            currencyConvertion.setToCurrency(toCurrencyManu.show());

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url +
                                    currencies.get(currencyConvertion.getFromCurrency()) +
                                    "/" +
                                    currencies.get(currencyConvertion.getToCurrency())
                                    ))
                    .build();

                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                CurrencyConvertionOMDB currencyConvertionOMDB = gson
                    .fromJson(json, CurrencyConvertionOMDB.class);

                currencyConvertion.setConvertion(currencyConvertionOMDB.getConvertionRate());
                JOptionPane.showMessageDialog(null, currencyConvertion.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);

                Object[] options = { "SI", "NO" };
                int optionRepeat = JOptionPane.showOptionDialog(null, "¿Desea realizar otra conversión?", "Warning",
                                                                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                                                null, options, options[0]);
                if (optionRepeat == 1) repeat = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null, "Programa Terminado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

}
