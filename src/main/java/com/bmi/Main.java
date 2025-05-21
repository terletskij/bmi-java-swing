package com.bmi;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalcFrame frame = new BMICalcFrame();
            frame.setVisible(true);
        });
    }
}