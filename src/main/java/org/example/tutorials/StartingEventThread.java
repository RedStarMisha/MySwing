package org.example.tutorials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class StartingEventThread {
    public void start() {
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(new CustomQueue());
        JFrame frame = new JFrame("Thread");
        JCheckBox checkBox = new JCheckBox("Тест");
        frame.add(checkBox);
        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);
        frame.add(list);
        model.addElement("Тест");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private class CustomQueue extends EventQueue {
        // метод кладет событие в очередь
        public void postEvent(AWTEvent event) {
            System.out.println("post(), поток: " +
                    Thread.currentThread());
            System.out.println("post(), событие: " + event);
            super.postEvent(event);
        }
        // метод распределяет событие по компонентам
        protected void dispatchEvent(AWTEvent event) {
            if (event instanceof MouseEvent) {

            } else {
                System.out.println("dispatch(), поток: " +
                        Thread.currentThread());
                System.out.println("dispatch(), событие: " + event);
                super.dispatchEvent(event);
            }
        }
    }
}
