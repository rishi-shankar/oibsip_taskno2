import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Randomnum extends JFrame{

    static String num;
    static int plc;
    JLabel j1 = new JLabel();
    
    static Random r = new Random();
    static int rng;
    static int count = 0;

    public static void numgen() {
        rng = r.nextInt(1,101);
    }

    public static void gameLogic(JLabel j1) {
        plc = Integer.parseInt(num);
        if (plc > rng) {
            if (plc - rng <= 10) {
                j1.setText("A bit High. Try Again");
                j1.setForeground(Color.YELLOW);
            } else {
                j1.setText("Too High. Try Again");
                j1.setForeground(Color.RED);
            }
        } else if (plc < rng) {
            if (rng - plc <= 10) {
                j1.setText("A bit Low. Try Again");
                j1.setForeground(Color.YELLOW);
            } else {
                j1.setText("Too Low. Try Again");
                j1.setForeground(Color.RED);
            }
        } else if (plc == rng) {
            j1.setText("Correct Guess!");
            j1.setForeground(Color.GREEN);
        }
    }

    Randomnum() 
    {
        setTitle("Random Number Game");
        
        getContentPane().setBackground(new Color(50, 50, 50));
        JLabel j2 = new JLabel("Guess a number between 1 to 100: ");
        j2.setForeground(Color.WHITE);
        JLabel j3 = new JLabel("Random Number Generated!");
        j3.setForeground(Color.WHITE);
        JLabel j4 = new JLabel("Number of Tries : " + count);
        j4.setForeground(Color.WHITE);
        j4.setBounds(20, 20, 300, 20);
        j3.setBounds(20, 200, 300, 20);
        j2.setBounds(20, 50, 300, 20);
        j1.setBounds(20, 80, 300, 20);
        
        
        JButton b1 = new JButton("Submit");
        b1.setBounds(140, 140, 100, 30);
        b1.setBackground(new Color(0, 102, 204));
        b1.setForeground(Color.WHITE);
        
        JButton b2 = new JButton("New Game");
        b2.setBounds(20, 140, 100, 30);
        b2.setBackground(new Color(34, 177, 76));
        b2.setForeground(Color.WHITE);

        JTextField t1 = new JTextField();
        t1.setBounds(220, 50, 100, 20);
        t1.setBackground(new Color(240, 240, 240));
        t1.setForeground(BLACK);
        setLayout(null);
        setSize(400,400);
        add(j2); add(t1); add(j1); add(b1); add(b2); add(j4); add(j3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        numgen();
        b1.addActionListener((ActionEvent e) -> 
        {
            num = t1.getText();
            gameLogic(j1);
            count++;
            j4.setText("Number of Tries : " + count);
            j3.setVisible(false);
        });
        b2.addActionListener((ActionEvent e) -> 
        {
            numgen();
            j3.setVisible(true);
            j1.setText("");
            count = 0;
            j4.setText("Number of Tries : " + count);
        });
    }

    public static void main(String[] args) {
        Randomnum obj = new Randomnum();
    }
}