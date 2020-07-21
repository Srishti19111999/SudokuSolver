
import java.awt.*;
import java.awt.event.*;



class MyDigitalButton extends Button implements ActionListener  
{   private static final long serialVersionUID = -6552319171850636837L;
Sudoku cl;  

MyDigitalButton(int x,int y, int width,int height,String cap, Sudoku clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  

} 

public void actionPerformed(ActionEvent ev)  
{  MyDigitalButton numclick=(MyDigitalButton)ev.getSource();
String tempText=numclick.getLabel();
//cl.setval(tempText);
numclick.setBackground(Color.CYAN);
System.out.println(tempText);
cl.setval(tempText);
cl.solvelabel.setText(tempText);
}

  
}