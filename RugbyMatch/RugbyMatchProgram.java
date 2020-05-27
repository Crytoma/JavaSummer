package RugbyMatch;

import java.util.*;

import javax.swing.JOptionPane;

class Player 
{
    String Name;
    int Score;
}

public class RugbyMatchProgram
{
    public static void main(String[] args) 
    {
        int numberOfPlayers = 3;
        List <Player> players = new ArrayList <Player>();
        
        //Set names
        for (int i = 1; i <= numberOfPlayers; i ++)
        {
            String name = JOptionPane.showInputDialog("Please enter the name of player " + i + ": ");
            Player p = new Player();
            setName(p, name);
            setScore(p, 0);
            players.add(p);
        }

        String name = "";
        while (!name.equals("END"))
        {
           
            name = JOptionPane.showInputDialog("Who has scored (END to finish)? ");
            Player p = getPlayer(players, name); 

            if (p == null && !name.equals("END"))
            {
                JOptionPane.showMessageDialog(null, "Player not found try again.");
            }
            else if (p != null)
            {
                int scoreAmount = Integer.parseInt(JOptionPane.showInputDialog("How many points? "));
                addScore(p, scoreAmount);
            }
        }


       //Collections.sort(players, Collections.reverseOrder());

        System.out.println("Final points totals:");

        for (Player p : players)
        {
            System.out.println(p.Name + "\t" + p.Score + " points");
        }

    }

    public static Player getPlayer(List <Player> players, String name)
    {
        Player p = null;

        for (Player player : players)
        {
            if (player.Name.equals(name))
            {
                p = player;
            }
            else
            {
                return p;
            }
        }
        return p;
    }

    public static String getName(Player p, String name)
    {
        return p.Name;
    }

    public static int getScore(Player p, int score)
    {
        return p.Score;
    }

    public static void setName(Player p, String name)
    {
        p.Name = name;
    }

    public static void setScore(Player p, int score)
    {
        p.Score = score;
    }

    public static void addScore(Player p, int scoreAmount)
    {
        p.Score += scoreAmount;
    }

}