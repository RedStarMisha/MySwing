package org.example.tutorials;

import javax.swing.*;
import java.awt.*;
public class InvokeLater extends JFrame {
    private JButton button;
    public InvokeLater() throws HeadlessException {
        super("InvokeLater");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button = new JButton("Hard Work");
        button.addActionListener(e -> {
            new ComplexJobThread().start();
            button.setText("Ждем");
        });
        setLayout(new FlowLayout());
        add(new JTextField(20));
        add(button);
        setSize(300, 300);
        setVisible(true);
    }

    class ComplexJobThread extends Thread {
        public void run() {
            try {
// изобразим задержку
                sleep(3000);
// работа закончена, нужно изменить интерфейс
                EventQueue.invokeLater(() -> button.setText("Работа завершена"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
