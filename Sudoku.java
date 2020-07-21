
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Sudoku extends Frame
{ private static final long serialVersionUID = -6552319171850636836L;
    public boolean setClear=true;  
    String digitButtonText[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9","0"};
    MyDigitalButton digitButton[]=new MyDigitalButton[digitButtonText.length]; 
     MyGrid grid[][]=new MyGrid[9][9];  
     String text;
    final int FRAME_WIDTH=600,FRAME_HEIGHT=600;  
    final int HEIGHT=40, WIDTH=40, H_SPACE=10,V_SPACE=10;  
    final int TOPX=410, TOPY=30;
    JLabel solvelabel;
    Sudoku(String frameText)//constructor  
    {  
    super(frameText);  
    int tempX=TOPX, y=TOPY;  
    int digitX=TOPX+WIDTH+H_SPACE;  
    int digitY=TOPY+2*(HEIGHT+V_SPACE);
    tempX=digitX;  y=digitY;  
    
    JLabel label = new JLabel("Click the number button and then click the box you want to add a number !");
    label.setBounds(30,20,505,60); 
    label.setFont(new Font("serif",Font.BOLD, 15));
        add(label);
    for(int i=0;i<digitButton.length;i++)  
    {  
    digitButton[i]=new MyDigitalButton(tempX,y,WIDTH,HEIGHT,digitButtonText[i], this);  
    digitButton[i].setForeground(Color.BLUE);  
    digitButton[i].setFont(new Font("serif",Font.BOLD, 15));
    tempX+=WIDTH+H_SPACE;  
         if((i+1)%2==0)
         {
        tempX=digitX; y+=HEIGHT+V_SPACE;
        } 
    }

    JButton b=new JButton("Generate");  
    b.setBounds(50,500,105,40);  
    b.setFont(new Font("serif",Font.BOLD, 16));
    add(b); 
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                MyGrid.printgrid(grid);  
                }  
    });
  
int p=40,q=90;

for(int i=0;i<=8;i++)
{  
     for(int j=0;j<=8;j++)
    { 
        grid[i][j]=new MyGrid(p,q,42,42,"",this,i,j); 
        grid[i][j].setForeground(Color.black);

        //grid[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.RED));
        if(j==8)  
        {
         q+=42; p=40;
        }
        else{
            p+=42;
        }
    }
}   
solvelabel = new JLabel();

solvelabel.setBounds(500,500,60,60); 
solvelabel.setFont(new Font("serif",Font.BOLD, 24));
    add(solvelabel);


addWindowListener(new WindowAdapter()  
    {  
    public void windowClosing(WindowEvent ev)  
    {System.exit(0);}  
    });  
      
    setLayout(null);  
    setSize(FRAME_WIDTH,FRAME_HEIGHT);  
    setVisible(true);  
} 

public String getval(){
    return text;
}
public void setval(String temptext){
    text= temptext;
}
 public static void main(String[] args) 
    {
    new Sudoku("Suduko Generator");    
    }
}


