package org.example;

import org.example.tutorials.InvokeLater;
import org.example.tutorials.MySwingWorker;
import org.example.tutorials.StartingEventThread;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MySwingWorker();
//            }
//        });
        new StartingEventThread().start();
    }
}