package LeapYearCheckerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class LeapYearCheckerUI extends JFrame{
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JPanel panel;

    private boolean checkLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    LeapYearCheckerUI(){
        panel.setBackground(Color.GRAY);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfYear.getText().compareTo("") == 0) {
                        throw new InputMismatchException("Please enter a number");
                    }
                    int year = 0;
                    try {
                        year = Integer.parseInt(tfYear.getText());
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(null, "Please enter a number");
                        return;
                    }
                    if(year < 0){
                        throw new InputMismatchException("Please enter a non-negative number");
                    }
                    if (checkLeapYear(year)) {
                        JOptionPane.showMessageDialog(null, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not leap year");
                    }
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
    }



    public static void main(String[] args) {
        LeapYearCheckerUI frame = new LeapYearCheckerUI();
        frame.setContentPane(frame.panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Leap Year Checker");
        frame.setVisible(true);
    }
}

