package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // завершаем программу при закрытии окна
            setLocationRelativeTo(null);
            setBounds(300, 300, 400, 400);
            JButton[] jbs = new JButton[5];
            for (int i = 0; i < 5; i++) {
                jbs[i] = new JButton("#" + i);
                jbs[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(((JButton)e.getSource()).getText() + " was pressed");
                    }
                });
            }
//            setLayout(new BorderLayout()); // выбор компоновщика элементов
            add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
            add(jbs[1], BorderLayout.WEST);
            add(jbs[2], BorderLayout.SOUTH);
            add(jbs[3], BorderLayout.NORTH);
            add(jbs[4], BorderLayout.CENTER);
            setVisible(true);
        }
    }

    public static void main(String[] args) {

        new MyWindow();
    }
}
