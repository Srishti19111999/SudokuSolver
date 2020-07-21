import java.awt.*;
import java.awt.event.*;

public class MyGrid extends Button implements ActionListener
{ private static final long serialVersionUID = -6552319171850636837L;
    Sudoku c2;
    int num,row,col;

  final static int gridsudoku[][]={
        {0,0,0,0,0,0,0,0,0}, 
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0}
    };
    MyGrid(int x,int y, int width,int height,String s ,Sudoku clc,int r,int c)
{   super(s);
    setBounds(x,y,width,height); 
    this.row=r;
    this.col=c;
    this.c2=clc;  
    this.c2.add(this);
    
    addActionListener(this);  
}
public int getrow()
{
    return this.row;
}
public int getcol()
{
    return this.col;
}

public void actionPerformed(ActionEvent ev)  
{  
MyGrid cellclicked=(MyGrid)ev.getSource();
for (int i=0;i<9;i++)
{
     if(cellclicked.getrow()==i)
    {
        for(int j=0;j<9;j++)
        {
            if(cellclicked.getcol()==j)
            {
              String val=c2.getval();
                gridsudoku[i][j]=Integer.parseInt(val);
                String ss=String.valueOf(gridsudoku[i][j]);
                cellclicked.setLabel(ss);
                cellclicked.setBackground(Color.YELLOW);
                cellclicked.setFont(new Font("serif",Font.BOLD, 18));
               
                break;
            }
        }
    }   
}
;
}
public static void printgrid(MyGrid [][]grid)
{ 
    SudokuSolve solvesudoku=new SudokuSolve(gridsudoku);
    if(solvesudoku.solve(grid)){
        System.out.println("Solved sudoku");
       
    } else {
        System.out.println("This sudoku cannot be solved");
    }
for(int i=0;i<gridsudoku.length;i++)
{
    for(int j=0;j<gridsudoku.length;j++)
    {
        System.out.print(gridsudoku[i][j]);
    }
    System.out.println();
}
solvesudoku.printSudoku();
}



}