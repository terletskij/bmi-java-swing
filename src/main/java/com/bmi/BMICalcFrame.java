package com.bmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalcFrame extends JFrame {

    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;

    public BMICalcFrame() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,420);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel weightLabel = new JLabel("Вага (кг):");
        weightField = new JTextField();

        JLabel heightLabel = new JLabel("Зріст (см):");
        heightField = new JTextField();

        JButton calcButton = new JButton("Розрахувати");
        resultLabel = new JLabel("Ваш BMI: ", JLabel.CENTER);
        resultLabel.setForeground(Color.BLUE);

        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });
        panel.add(weightLabel);
        panel.add(weightField);

        panel.add(heightLabel);
        panel.add(heightField);

        panel.add(new JLabel());
        panel.add(calcButton);

        panel.add(new JLabel());
        panel.add(resultLabel);

        add(panel);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double heightCm = Double.parseDouble(heightField.getText());
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            String category;
            if (bmi < 18.5) category = "Недостатня вага";
            else if (bmi < 25) category = "Норма";
            else if (bmi < 30) category = "Надмірна вага";
            else category = "Ожиріння";

            resultLabel.setForeground(Color.BLUE);
            resultLabel.setText(String.format("Ваш BMI: %.1f (%s)", bmi, category));
        } catch (NumberFormatException ex) {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Помилка: введіть коректні числа.");
        }
    }
}
