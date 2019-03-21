import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.lang.Object;

public class square extends JButton implements ActionListener // creates a subclass of JButton
{

    private int thisRow;
    private int col;
    private String pType;
    public void main(String[] args)
    {
        System.out.println("hi"); 
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {  //When the ActionListener detects a mouse click
                e.getActionCommand();    //does nothing 
              //if statement checks if the piece is red or white and if the type is the same as the player whose turn it is
              // ensures the white can only click on white pieces and red can only select red pieces
               if((pType == "RED" || pType == "WHITE") && pType == board.currentPlayer) 
               {
                //first click
                 board.prevSq = this; //remember previously clicked square
                 board.clearBoard(); //removes possible moves marking
                 board.showPossible(); //shows the available moves to the player

               }
               else if(pType == "YELLOW") //if it is an allowed move
               {
                    //second click on allowed destination square
                    board.prevSq.moveTo(this);  //runs the move

                    if(board.pieceToTake != null)
                    {
                        board.pieceToTake.setImage("NONE");
                    }
                    board.clearBoard();//clears the board of the yellow squares
                    if (board.currentPlayer == "WHITE") //If it is the white player's turn
                    {
                        board.currentPlayer = "RED";
                    }
                    else //if it is the red player's turn
                    {
                        board.currentPlayer = "WHITE";
                    }
                
               
               
                     //implement move on previous square to current square
                    
               }

            }

    //checks if the piece can move to the desired square

    public boolean canMoveTo(square testSq)
    {
        boolean canGo = false;
        
        //red pieces can move down one row, white pieces can move up one row, and one column either way
        if(this.pType == "RED" && testSq.getImage() == "NONE" && testSq.thisRow == (this.thisRow + 1) && (testSq.col == (this.col + 1) || testSq.col == (this.col - 1)))
            {
                canGo = true;
            }
        
        else if(this.pType == "WHITE" && testSq.getImage() == "NONE" && testSq.thisRow == (this.thisRow - 1) && (testSq.col == (this.col + 1) || testSq.col == (this.col - 1)))
            {
                canGo = true;
            }

        
        return canGo;

        
    }
    //Runs a check to see if the piece can be taken
    public boolean canTake(square testSq)
    {
        boolean take = false;
        
        //check to see if there is a piece that can be taken diagonally
        if(this.pType == "RED" && testSq.getImage() == "WHITE" && testSq.thisRow == (this.thisRow + 1) && (testSq.col == (this.col + 1) || testSq.col == (this.col - 1)))
            {
                take = true;
            }
        
        else if(this.pType == "WHITE" && testSq.getImage() == "RED" && testSq.thisRow == (this.thisRow - 1) && (testSq.col == (this.col + 1) || testSq.col == (this.col - 1)))
            {
                take = true;
            }

        
        return take;

        
    }

    public boolean canJumpTo(square testSq)
    {
        boolean canJump = false;
        
        //red pieces can move down one row, white pieces can move up one row, and one column either way
        if(this.pType == "RED" && testSq.getImage() == "NONE" && testSq.thisRow == (this.thisRow + 2) && (testSq.col == (this.col + 2) || testSq.col == (this.col - 2)))
            {
                canJump = true;
            }
        
        else if(this.pType == "WHITE" && testSq.getImage() == "NONE" && testSq.thisRow == (this.thisRow - 2) && (testSq.col == (this.col + 2) || testSq.col == (this.col - 2)))
            {
                canJump = true;
            }

        
        return canJump;

        
    }
    //square constructor
    public square(String name, int jRow, int jCol, String image)
    {
        super(name); //invoke the superclass constructor - JButton constructor
        thisRow = jRow;
        col = jCol;
        
        setImage(image);
        
        
    }

     
    //gets the row for the square
    public int getRow()
    {
        return thisRow;
    }
    //gets the current image of the square
    public String getImage()
    {
        return pType;
    }
    //gets the column for the square
    public int getCol()
    {
        return col;
    }
    //stores the value of the row of the square
    public void setRow(int rowSet)
    {
        thisRow = rowSet;
    }
    //stores the value of the column of the square
    public void setCol(int colSet)
    {
        col = colSet;
    }
    // sets the image of the desired square and clears the place the piece was on
    //simulates the movement of one piece to another
    public void moveTo(square destSq)
    {
        
        destSq.setImage(pType);
        setImage("NONE");
    
    }
    //alters the icon depending on the parameter 
    public void setImage(String colour)
    {
        pType = colour;
        if(colour == "RED")
        {
            this.setIcon(new ImageIcon("red.png"));
            
        }
        else if(colour == "WHITE")
        {
            this.setIcon(new ImageIcon("white.png"));
        }
        else if(colour == "BLACK")
        {
            this.setIcon(new ImageIcon("empty2.png"));

        }
        else if(colour == "YELLOW")
        {
            this.setIcon(new ImageIcon("selected.png"));

        }
        else 
        {
            this.setIcon(new ImageIcon("empty.png"));

        }


    }

    
}