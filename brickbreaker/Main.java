package brickbreaker;

import javax.swing.JFrame;;

public class Main   
{
    public static void main(String [] arguments)
    {
        JFrame frame = new JFrame();
        Gameplay gamePlay = new Gameplay();
        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("Bricker Breaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePlay);
    }
}

