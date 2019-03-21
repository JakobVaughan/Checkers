
 

import javax.swing.*;



import java.awt.GridLayout;

import java.awt.*;
import java.lang.Object;

public class board 
{

        public static square prevSq;

        private static  JFrame window = new JFrame();
        private static JPanel panel = new JPanel();
        private int o = 0;
        private int type = 1;
        public static square[][] button = new square[8][8];
        JButton press = new JButton();
    
        public static void main(String[] args)
        {
            
            panel.setLayout(new GridLayout(8 ,8, 0, 0));
        
            String str = "btn";
            int colour = 0;
            
            for(int i = 0; i<8; i++)
            {

            
                for(int j=0;j<8;j++)
                    {
    
                        if(colour==0) //black
                        {
       
                            button[i][j] = new square(str+i+j, i, j, "BLACK");
                        
                            panel.add(button[i][j]);

                            colour = 1;

                        }
                        else //white
                        {                                             
                            
                            panel.add(button[i][j]);
                                            
                            colour = 0;
                            
                        }

                    }

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
            

            window.setSize(800,800);
        
        
            panel.setVisible(true);
            window.add(panel);
            
        
            window.setVisible(true);
            System.out.println("Hello World!");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    
}