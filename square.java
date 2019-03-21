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


    public square(String name, int jRow, int jCol, String image)
    {
        super(name); //invoke the superclass constructor - JButton constructor
        thisRow = jRow;
        col = jCol;
        
        setImage(image);
        
        
    }

    
}