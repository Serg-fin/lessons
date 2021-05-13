package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingExample extends JFrame {
        public DrawingExample() {
            super("Lines Drawing Demo");
            setSize(319, 341); // ширина  высота
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setAlwaysOnTop(true);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("MousePos: " + e.getX() + " " + e.getY());
                }});
        }
        @Override
        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;

            super.paint(g);
            simpleDrawLines(g);
        }

    private void simpleDrawLines(Graphics g2d) {
            g2d.fillPolygon(new int[] {400}, new int[] {400}, 1);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(8, 29, 303, 303);
            g2d.setColor(Color.BLACK);
            g2d.drawLine(8, 30,311, 30); //
            g2d.drawLine(8, 332,311, 332); //
            g2d.drawLine(8, 30,8, 332); //
            g2d.drawLine(310, 30,310, 332); //

            g2d.drawLine(109, 30, 109, 333);
            g2d.drawLine(210, 30, 210, 333);
            g2d.drawLine(8, 131, 311, 131);
            g2d.drawLine(8, 232, 311, 232);

//            g2d.drawOval(350, 150, 150, 150);
//            g2d.setColor(Color.RED);
//            g2d.fillOval(351, 151, 149, 149);
//            g2d.clearRect(350, 150, 75, 75);
//            g2d.clearRect(350, 150, 75, 75);
        }

        public static void main(String[] args) {
            new DrawingExample().setVisible(true);
        }

}
