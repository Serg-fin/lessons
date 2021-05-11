package lesson8;

import javax.swing.*;
import java.awt.*;

public class Window {

    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // завершаем программу при закрытии окна
//            setLocationRelativeTo(null);
            setSize(400, 400); // задаем размер окна
            setLocation(300, 300); // задаем начало координат окна
            setVisible(true);
        }
    }

    private static class WindowRunnable implements /* extends */ Runnable {

        @Override
        public void run() {
            new MyWindow();
        }
    }

    public static void main(String[] args) {
//        new MyWindow();
//        EventQueue.invokeLater(new WindowRunnable());
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });
    }
}
