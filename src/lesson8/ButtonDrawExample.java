package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDrawExample {
    static class MyWindow extends JFrame {

        private static final String DRAW_X = "DRAW_X";
        private static final String DRAW_O = "DRAW_O";

        public MyWindow() {
            setSize(319, 341);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            setLayout(new GridLayout(3, 3));
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());
            add(createButton());

            setVisible(true);
        }

        private JButton createButton() {
            return new JButton() {

                {
                    setActionCommand(DRAW_O);
                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String action = getActionCommand().equals(DRAW_O) ? DRAW_X : DRAW_O;
                            setActionCommand(action);
                        }
                    });

                }

                @Override
                public void paint(Graphics graphics) {
                    super.paint(graphics);

                    if (getActionCommand().equals(DRAW_O)) {
                        graphics.drawOval(0, this.getHeight() / 100, getWidth() / 2, getWidth() / 2);
                        graphics.setColor(Color.RED);
                        graphics.fillOval(0, this.getHeight() / 100, getWidth() / 2, getWidth() / 2);
                    } else {
                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.setStroke(new BasicStroke(10)); // setStroke задает ширину для линии которую рисуем
                        g2d.setColor(Color.YELLOW);
                        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                        g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
                    }
                }
            };
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}