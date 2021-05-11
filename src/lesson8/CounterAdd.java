package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CounterAdd extends JFrame {
    private int value;

    public CounterAdd(int initialValue) {

        JOptionPane pane = new JOptionPane("                          Введите число");
        JDialog dialog = pane.createDialog(CounterAdd.this, "Сообщение");
        dialog.setLocation(600, 300);
        dialog.setVisible(true);
        dialog.dispose();

        setBounds(600, 300, 300, 250);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // завершаем программу при закрытии окна
        setAlwaysOnTop(true); // наше окно всегда наверху
        Font font = new Font("Arial", Font.BOLD, 32);

        JTextField field = new JTextField(); //****
        add(field, BorderLayout.PAGE_START); //****

        JLabel counterValueView = new JLabel(String.valueOf(value)); // текстовое поле где отображается значение счетчика
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;

        JButton decrementButton = new JButton("<"); // дикрементирует т.е. уменьшает значение счетчика
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.LINE_START);

        JButton incrementButton = new JButton(">"); // инкрементирует т.е. увеличивает значение счетчика
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.LINE_END);

        JButton resetButton = new JButton("Сброс");
        resetButton.setFont(font);
        add(resetButton, BorderLayout.PAGE_END);


        field.addFocusListener(new FocusListener() { // слушатель проверяет сделана ли запись в текстовом поле, по умолчанию задает пустое поле
            @Override
            public void focusGained(FocusEvent e) {
                field.setText("");
            }

            @Override
            public void  focusLost(FocusEvent e) { // слушатель, если курсор не в текстовом поле, сравнивает строку (equals) на пустоту
                                                   // и если true, то задает в поле значение "0"

                if (field.getText().equals("")){
                    field.setText("0");
                    JOptionPane.showMessageDialog(CounterAdd.this, "ОШИБКА: " + "\n" + "число не задано");
                }
            }
        });

        field.addActionListener(new ActionListener() { // слушатель ввода значения в текстовом поле
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                value = Integer.parseInt(field.getText());
                refreshCounterLabel(counterValueView);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value = 0;
                field.setText("0");

                refreshCounterLabel(counterValueView); // очистка текстового поля счетчика

                JOptionPane.showMessageDialog(CounterAdd.this, "Введите другое число");
            }
        });
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                value = (value - Integer.parseInt(field.getText()));
                refreshCounterLabel(counterValueView);
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value = (value + Integer.parseInt(field.getText()));
                refreshCounterLabel(counterValueView);
            }
        });

//        JOptionPane.showMessageDialog(CounterAdd.this, "Введите число");

        setVisible(true);
    }

    private void refreshCounterLabel(JLabel counterValueView) {
        counterValueView.setText(String.valueOf(value));
    }

    public static void main(String[] args) {

        new CounterAdd(0);
    }
}


