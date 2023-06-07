package org.example.tutorials;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class MySwingWorker extends JFrame {
    private JButton button;
    private JLabel label;

    public MySwingWorker() throws HeadlessException {
        super("MySwingWorker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button = new JButton();
        button.addActionListener(e -> {
            new ComplexJob().execute();
        });
        label = new JLabel("Кот");
        setLayout(new FlowLayout());
        add(button);
        add(label);
        setSize(300, 300);
        setVisible(true);
    }
    class ComplexJob extends SwingWorker<String,String> {
        // здесь выполняется работа, это отдельный поток! Макс количество таких одновременных потоков (потомков SwingWorker) 10, остальные встают в очередь
        public String doInBackground() throws Exception {
            Thread.sleep(2000);
// публикуем промежуточные результаты
            publish("Половина работы закончена...", "Кот становится..");
            Thread.sleep(2000);
            return "";
        }

        // обработка промежуточных результатов
// это поток рассылки событий!
        protected void process(List<String> chunks) {
            button.setText(chunks.get(0));
            label.setText(chunks.get(1));
        }

        // окончание работы - и вновь это поток рассылки
        public void done() {
            button.setText("Работа завершена");
            label.setText("Псом");
        }
    }
}
