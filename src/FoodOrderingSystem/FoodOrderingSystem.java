package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;

public class FoodOrderingSystem extends JFrame{

    static Dictionary foodPrices = new Hashtable<String, Float>(){{put("Pizza", 100f); put("Burger", 80f); put("Fries", 65f);
        put("Soft Drinks", 55f); put("Tea", 50f); put("Sundae", 40f);}};
    static Dictionary discountPerc = new Hashtable<String, Float>(){{put("None", 1f); put("5% Off", .95f); put("10% Off", .9f);
        put("15% Off", .85f);}};
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JRadioButton rb5Off;
    private JRadioButton rb10Off;
    private JRadioButton rb15Off;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JPanel panel;

    FoodOrderingSystem(){

        JRadioButton[] bgDiscounts = {rbNone, rb5Off, rb10Off, rb15Off};
        JCheckBox[] cbFoods = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};


        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float total = 0;
                for(JCheckBox cb : cbFoods){
                    if(cb.isSelected()){
                        total += (float)foodPrices.get(cb.getText());
                    }
                }
                for(JRadioButton rb : bgDiscounts){
                    if(rb.isSelected()){
                        total *= (float)discountPerc.get(rb.getText());
                        break;
                    }
                }
                String message = "The total price is Php " + String.format("%.2f", total);
                if(total == 0){
                    message += "\nYou didn't bought anything...";
                }
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderingSystem frame = new FoodOrderingSystem();
        frame.setContentPane(frame.panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Food Ordering System");
        frame.setVisible(true);
    }
}
