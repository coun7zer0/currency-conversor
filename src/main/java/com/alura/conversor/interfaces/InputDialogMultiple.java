package com.alura.conversor.interfaces;

import java.util.List;

import javax.swing.JOptionPane;

public class InputDialogMultiple {
    private Object[] values;
    private String message;

    public InputDialogMultiple(List values, String message) {
        this.values = values.toArray(new Object[0]);
        this.message = message;
    }

    public String show() {
        return JOptionPane.showInputDialog(null,
                                           message,
                                           "Currency Conversor",
                                           JOptionPane.QUESTION_MESSAGE,
                                           null,
                                           values,
                                           values[0]).toString();
    }
}