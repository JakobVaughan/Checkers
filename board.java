
 
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;



import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.lang.Object;

public class board 
{
        //instance variables for board
        public static square prevSq; //remembers the previously clicked square 
        public static String currentPlayer = "WHITE"; // tracks the current player - white starts
        private static  JFrame window = new JFrame(); //creates the window for the game
        private static JPanel panel = new JPanel(); // creates the panel which is put onto the window
        public static square[][] button = new square[8][8]; //creates an array of buttons (64)
   
    
        public static void main(String[] args)
        {

            panel.setLayout(new GridLayout(8 ,8, 0, 0)); //creates a swing gridlayout for an 8*8 grid

            String str = "btn";
            int colour = 0;
            

            //loops through 8 rows and 8 columns
            for(int i = 0; i<8; i++)
            {

            
                for(int j=0;j<8;j++)
                    {
                        
                       
                       
                        if(colour==0) //if the square needs to be black
                        {

                            button[i][j] = new square(str+i+j, i, j, "BLACK");//creates a button
                        
                            

                            colour = 1; //sets the colour to one, next loop goes to the else statement

                        }

                        else //if the square needs to be white
                        {
 
                            //sets the starting point for the red side, they need to have red pieces
                            if(i==0 || i==1 || i==2)
                                {
                                    button[i][j] = new square(str+i+j, i, j, "RED"); //creates a red piece 
                        
                                }
                            
                            // sets the starting point for the white side, they need to have white pieces
                            else if(i==5 || i==6 || i==7)
                                {
                                    button[i][j] = new square(str+i+j, i, j, "WHITE"); //creates a white piece
                           
                                }
                            //the remaining pieces are blank
                            else
                                {
                                    button[i][j] = new square(str+i+j, i, j, "NONE"); //creates a blank square


                                }    
                            
                            button[i][j].addActionListener(button[i][j]);  //implements an action listener on the created button                        
    
                            colour = 0; //switches the colour
                            
                        }
                        panel.add(button[i][j]);//adds the button to the panel

                    }
                    // once it is a new row, this switches the first square colour around
                    if(colour == 0)
                    {
                        colour = 1;
                    }
                    else
                    {
                        colour = 0;
                    }

            }

            window.pack(); 
            

            window.setSize(800,800); //sets the window size to 800 by 800 pixels
        
        
            panel.setVisible(true); //makes the panel visible to the player(s)
            window.add(panel); //adds the panel to the window
            
        
            window.setVisible(true); //makes the window visible to the player(s)
            System.out.println("Hello World!");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the program exit once the window has been closed
        }

        public void showRow(square thisSquare)
        {
            thisSquare.getRow();
        }
        //finds all the possible legal moves for the player and highlights them in yellow
        public static void showPossible()
        {
            // goes through all of the button
            for(int k = 0; k<=7; k++)
            {          
                for(int l=0; l<=7; l++)
                {

                    //checks if any of the buttons can be moved to legally
                    if(prevSq.canMoveTo(button[k][l]))
                    {
                        
                       // System.out.println("canMoveTo is true at: " + k + " and " + l); 
                        

                        button[k][l].setImage("YELLOW"); //sets the legal destination squares to yellow
                    }
                }
            }
            
        }
        //Checks through the buttons for any yellow squares and sets them to blank
        public static void clearBoard()
        {
            //runs through all of the buttons
            for(int k = 0; k<=7; k++)
            {          
                for(int l=0; l<=7; l++)
                {
                    //checks if the image is yellow
                    if(button[k][l].getImage() == "YELLOW")
                    {
                        //sets the icon to a blank
                        button[k][l].setImage("NONE");
                    }
                }
            }
            
        }

}