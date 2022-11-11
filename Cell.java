import javax.swing.JButton;
import java.awt.Color;
/**
 * This class creates a cell
 *
 * @author (Divine Badibanga)
 */
public class Cell extends JButton
{
    // instance variables
    private int x, y;  //cell's coordinates
    private int score; //current score
    private int newScore;
    public JButton button;
    
    /**
     * Constructor for objects of class Cell
     */
    public Cell(int xcoord, int ycoord, int newScore)
    {
        super();
        // initialise instance variables
        x = xcoord;
        y = ycoord;
        this.newScore = newScore;
        button = new JButton();
        if (newScore == -1){
        exceptions();}
        else {newCell();}
    }

    public void donner(){
        score += 1;
        //button.setText(text);
    }

    public void prendre(){
       score = 0;
       //button.setText(text);
    }

    private void newCell(){
        button.setText(String.valueOf(newScore));
    }

    private void exceptions(){
        if (this.x == 1 && this.y == 0){
            this.setBackground(Color.black);
        }
        else if (this.x == 0 && this.y == 7){
            this.setBackground(Color.black);
        }
        else if (this.x == 0 && this.y == 0){
            score = 0;
            this.setBackground(Color.green);
            button.setText(String.valueOf(score));
        }
        else if (this.x == 1 && this.y == 7){
            score = 0;
            this.setBackground(Color.green);
            button.setText(String.valueOf(score));
        }
        else {
            score = 4;
            this.setBackground(Color.white);
            button.setText(String.valueOf(score));
        }
    }

    public int getScore(){
        return score;
    }

    public void setScore(int newScore){
        this.score = newScore;
        button.setText(String.valueOf(score));
    }

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }
}