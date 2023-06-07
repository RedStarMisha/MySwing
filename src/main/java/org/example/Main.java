package org.example;

import org.example.tutorials.InvokeLater;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InvokeLater();
            }
        });
    }
}