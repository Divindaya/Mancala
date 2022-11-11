import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
/**
* A game of Mancala
*
* @author Divine Ndaya Badibanga
* @version 1.3
*/

public class Board extends JFrame implements ActionListener{

    private int x, y;  //dimensions of the grid
    private JPanel panel;
    private Cell [][] cells; //array containing all the cells

    public Board(){
        //initiate instance variables
        x = 2;
        y = 8;
        //create the window
        panel = new JPanel();
        JFrame aFrame = new JFrame();
        panel.setLayout(new GridLayout(x,x,1,1));
        panel.setPreferredSize(new Dimension(y*y*10,y*y*10));
        
        //build the grid with cells on it
        genesis();
    }

    /**
     * Genesis creates the grid of cells
     *
     */
    public void genesis()
    {
        //create a x by y grid and add cells
        cells = new Cell [x][y];
        for (int i=0; i<x; i++)
        {
            for (int j=0; j<y; j++)
            {
                cells [i][j] = new Cell(i,j, -1);
                cells [i][j].setSize(200,200);
                cells [i][j].setOpaque(true);
                cells [i][j].setBorderPainted(true);
    
                cells [i][j].addActionListener((ActionListener) this);
                
                panel.add(cells [i][j]);
            }
        }
        
        //set the display
        getContentPane().add(panel);
        panel.setVisible(true);
        
        pack();
        
        panel.setLayout(new GridLayout(x,x,1,1));
        
        //housekeeping
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /*
     *  handles actions performed in the gui
     *  this method must be present to correctly implement the ActionListener interface
     */
    public void actionPerformed (ActionEvent aevt)
    {
        // get the object that was selected in the gui
        Object selected = aevt.getSource();
        
        // if a gridsquare is selected then transfer seeds
        if ( selected instanceof Cell){
            var score = ((Cell)selected).getScore();
            System.out.println("this cell's seed bank is " + score);
            //replace this with a new cell
            //((Cell)selected).prendre(); 
            //new code
            var xcoord = ((Cell)selected).getx();
            var ycoord = ((Cell)selected).gety();
            var newScore = 0;
            cells [xcoord][ycoord] = new Cell(xcoord,ycoord, newScore);

            System.out.println("now it's " + ((Cell)selected).getScore());
            
            while (score > 0){
                if (xcoord == 0 && xcoord < 2){
                    ycoord -= 1; 
                    //replace this with new code
                    //cells [x][y].donner();
                    //new code 
                    newScore = cells [x][y].getScore() + 1;
                    cells [xcoord][ycoord] = new Cell(xcoord,ycoord, newScore);

                    score -= 1;
                    
                    System.out.println(xcoord + ", " + ycoord + " cell's seed bank is " + cells [xcoord][ycoord].getScore());
                    
                    if (ycoord == 0){
                        xcoord = 1;
                        ycoord = 0;
                    }

                }
                if (xcoord == 1 && ycoord < 8){
                    ycoord += 1;
                    //replace this with new code
                    //cells [xcoord][ycoord].donner();
                    //new code
                    newScore = cells [x][y].getScore() + 1;
                    cells [xcoord][ycoord] = new Cell(xcoord,ycoord, newScore);

                    score -= 1;

                    System.out.println(xcoord + ", " + ycoord + " cell's seed bank is " + cells [xcoord][ycoord].getScore());
                
                    if (ycoord == 7){
                        xcoord = 0;
                        ycoord = 7;
                    }
                }
                cells [xcoord][ycoord].setSize(200,200);
                cells [xcoord][ycoord].setOpaque(true);
                cells [xcoord][ycoord].setBorderPainted(true);
    
                cells [xcoord][ycoord].addActionListener((ActionListener) this); 
                    
                panel.add(cells [xcoord][ycoord]);
            }
        }
        //update();
    }

    public void update(){
        for (int i=0; i<x; i++)
        {
            for (int j=0; j<y; j++)
            {
                panel.add(cells [i][j]);}}
        //set the display
        getContentPane().add(panel);
        panel.setVisible(true);
        
        //housekeeping
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
}