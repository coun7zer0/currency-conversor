package com.alura.conversor.interfaces;

import java.util.List;

import javax.swing.JOptionPane;

public class InputDialogMultiple {
    private Object[] values;
    private String message;
    private int messageType;

    public InputDialogMultiple(List values, String message, int messageType) {
        this.values = values.toArray(new Object[0]);
        this.message = message;
        this.messageType = messageType;
    }

    public String show() {
        return JOptionPane.showInputDialog(null,
                                           message,
                                           "Currency Conversor",
                                           messageType,
                                           null,
                                           values,
                                           values[0]).toString();
    }
}