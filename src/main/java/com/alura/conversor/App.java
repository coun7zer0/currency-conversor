package com.alura.conversor;


import java.util.List;

import javax.swing.JOptionPane;

import com.alura.conversor.interfaces.InputDialogMultiple;
import com.google.inject.internal.util.Lists;

public class App 
{
    public static void main( String[] args )
    {
        List<Object> ConversionMenu = Lists.newArrayList("Conversor de Moneda", "Conversor de Temperatura");

        InputDialogMultiple DialogMultiple = new InputDialogMultiple(
                ConversionMenu,
                "Ingresa una opción de conversión",
                JOptionPane.QUESTION_MESSAGE);

        String message = DialogMultiple.show();
        System.out.println(message);
    }
}
