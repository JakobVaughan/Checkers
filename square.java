import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.lang.Object;

public class square extends JButton implements ActionListener
{

    private int thisRow;
    private int col;
    private String pType;
    public void main(String[] args)
    {
        System.out.println("hi");
        
        
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                e.getActionCommand();    
              //  System.out.println(getRow());
                //System.out.println(getCol());
               // moveTo(this);
               if((pType == "RED" || pType == "WHITE") && pType == board.currentPlayer)
               {
                
                 board.prevSq = this; //remember previously clicked square

               }
               else if(pType == "YELLOW")
               {

                    board.prevSq.moveTo(this);  
                    
                    if (board.currentPlayer == "WHITE")
                    {
                        board.currentPlayer = "RED";
                    }
                    else
                    {
                        board.currentPlayer = "WHITE";
                    }
        
               }

            }

    

    public square(String name, int jRow, int jCol, String image)
    {
        super(name); //invoke the superclass constructor - JButton constructor
        thisRow = jRow;
        col = jCol;
        
        setImage(image);
        
        
    }

     

    public int getRow()
    {
        return thisRow;
    }

    public String getImage()
    {
        return pType;
    }

    public int getCol()
    {
        return col;
    }

    public void setRow(int rowSet)
    {
        thisRow = rowSet;
    }

    public void setCol(int colSet)
    {
        col = colSet;
    }

    public void moveTo(square destSq)
    {
        //System.out.println(destSq.getIcon());
        
        destSq.setImage(pType);
        setImage("NONE");
    
    }

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