package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingExample extends JFrame {

    private static final String DRAW_X = "DRAW_X";
    private static final String DRAW_O = "DRAW_O";

        public DrawingExample() {
            super("Lines Drawing Demo");
            setSize(319, 341); // ширина  высота
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

            setAlwaysOnTop(true);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("MousePos: " + e.getX() + " " + e.getY());
                    setVisible(true);

                }});

        }
        @Override
        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;

            super.paint(g);
            simpleDrawLines(g);
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
                    graphics.drawOval(0, this.getHeight() / 200, getWidth() / 2, getWidth() / 2);
                    graphics.setColor(Color.RED);
                    graphics.fillOval(0, this.getHeight() / 200, getWidth() / 2, getWidth() / 2);
                } else {
                    Graphics2D g2d = (Graphics2D) graphics;
                    g2d.setStroke(new BasicStroke(5)); // setStroke задает ширину для линии которую рисуем
                    g2d.setColor(Color.YELLOW);
                    g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                    g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
                }
            }

        };
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

        }

        public static void main(String[] args) {
            new DrawingExample().setVisible(true);
        }

}
