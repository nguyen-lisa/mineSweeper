import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

public class Minesweeper extends JFrame implements ActionListener {
    private JButton [] button  = new JButton [90]; //array of buttons for the grid
    private int count = 0;

    public Minesweeper () {          
        super ("Mine Sweeper");
        setSize (1500, 700); //size of the window, 1500x700 pixels
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //closes program when user clicks the exit button
        setLayout (new GridLayout (9, 9)); //grid layout is 9x9
        init ();
    }

    private void init () {          
        count = 0;
        for (int i = 0; i < 90; ++i) {
            button [i] = new JButton ("hit or miss?"); //this is what the button on the grid will display
            button [i].addActionListener (this);
            add (button [i]);
        }
        setVisible (true); //makes the window frame visible
    }
     
     

    public void actionPerformed (ActionEvent a) {    
        String letter = "miss"; // this string is called 'letter'
        for (JButton jb : button) //button is called jb
        if (a.getSource () == jb) { //if jb is clicked...
            jb.setText (letter); //then it shows the string above called 'letter' and
            jb.setEnabled (false); //buttons disables when clicked
        }
        if (count == 9) {
            for (JButton jb : button)
                remove (jb) ;
            init ();
        }
    }

    public static void main (String [] args) { //main method          
        new Minesweeper (); //runs the MineSweeper method
    }
}