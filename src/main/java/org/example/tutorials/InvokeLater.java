package org.example.tutorials;

import javax.swing.*;
import java.awt.*;
public class InvokeLater extends JFrame {
    private JButton button;
    public InvokeLater() throws HeadlessException {
        super("InvokeLater");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel textField = new JLabel("Hi");
        button = new JButton("Hard Work");
        button.addActionListener(e -> {

            new ComplexJobThread().start();
            textField.setText("Привет");
            button.setText("Ждем");
        });


        //ТАк запускать поток нельзя, это может привести к конфликтам или блокировкам. Нужно это делать через поток событий
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(6000);
//                button.setText("Новый поток");
////                repaint();
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        thread.start();

        setLayout(new FlowLayout());
        add(textField);
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
