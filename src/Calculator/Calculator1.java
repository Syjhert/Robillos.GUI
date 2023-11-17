package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class Calculator1 extends JFrame{
    private JTextField tfNum1;
    private JTextField tfNum2;
    private JTextField tfResult;
    private JComboBox cbOperation;
    private JButton computeResultButton;
    private JPanel panel;

    Calculator1(){
        panel.setBackground(Color.GRAY);
        tfNum1.setHorizontalAlignment(JTextField.CENTER);
        tfNum2.setHorizontalAlignment(JTextField.CENTER);
        tfResult.setHorizontalAlignment(JTextField.CENTER);

        computeResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float res = 0, num1 = 0, num2 = 0;
                try{
                    if(tfNum1.getText().compareTo("") == 0){
                        throw new InputMismatchException("1st Number has no input");
                    }
                    if(tfNum2.getText().compareTo("") == 0){
                        throw new InputMismatchException("2nd Number has no input");
                    }

                    try {
                        num1 = Float.parseFloat(tfNum1.getText());
                        num2 = Float.parseFloat(tfNum2.getText());
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(null, "One or both of your inputs are not numbers");
                        return;
                    }

                    switch(cbOperation.getSelectedIndex()){
                        case 0:
                            res = num1 + num2;
                            break;
                        case 1:
                            res = num1 - num2;
                            break;
                        case 2:
                            res = num1 * num2;
                            break;
                        case 3:
                            if(num2 == 0){
                                throw new ArithmeticException("Denominator must be non-zero");
                            }
                            res = num1 / num2;
                            break;
                    }
                    tfResult.setText(String.format("%.2f", res));
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        Calculator1 frame = new Calculator1();
        frame.setContentPane(frame.panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Calculator");
        frame.setVisible(true);
    }
}
