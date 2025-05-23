package com.mycompany.milestonegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * creates the GUI for the Milestone GPA Calculator.
 */
public class MilestoneGUI extends JFrame implements ActionListener {
    private JTextField tM1, tM2, tTA, tTotal, tGPA; // Text fields for input and output
    private JButton btnCalculate;                    // Button to trigger calculation
    private MilestoneCalculator calculator;          // Calculator object

    public MilestoneGUI() {
        calculator = new MilestoneCalculator();

        setTitle("Milestone GPA Calculator");
        setSize(300, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5)); // 6 rows, 2 columns, 5px gaps

        // Add label and input for Milestone 1
        add(new JLabel("Milestone 1 (Max 25):"));
        tM1 = new JTextField();
        add(tM1);

        // Add label and input for Milestone 2
        add(new JLabel("Milestone 2 (Max 40):"));
        tM2 = new JTextField();
        add(tM2);

        // Add label and input for Terminal Assessment
        add(new JLabel("Terminal Assessment (Max 35):"));
        tTA = new JTextField();
        add(tTA);

        // Add label and output field for Total Points
        add(new JLabel("Total Points:"));
        tTotal = new JTextField();
        tTotal.setEditable(false); // Output only
        add(tTotal);

        // Add label and output field for GPA grade
        add(new JLabel("Grade (GPA 1-5):"));
        tGPA = new JTextField();
        tGPA.setEditable(false); 
        add(tGPA);

        // Add Calculate button
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this); 
        add(new JLabel("")); 
        add(btnCalculate);

        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Read and convert inputs to integers
            int m1 = Integer.parseInt(tM1.getText());
            int m2 = Integer.parseInt(tM2.getText());
            int ta = Integer.parseInt(tTA.getText());

            // Set values in calculator (validates input)
            calculator.setMilestone1(m1);
            calculator.setMilestone2(m2);
            calculator.setTerminalAssessment(ta);

            // Calculate total and GPA
            int total = calculator.calculateTotal();
            int gpa = calculator.calculateGPA();

            // Display results in output fields
            tTotal.setText(String.valueOf(total));
            tGPA.setText(String.valueOf(gpa));
        } catch (NumberFormatException ex) {
            // Show error if input is not a valid integer
            JOptionPane.showMessageDialog(this, "Please enter whole numbers only.");
        } catch (IllegalArgumentException ex) {
            // Show error if input is out of allowed range
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MilestoneGUI(); 
    }
}
