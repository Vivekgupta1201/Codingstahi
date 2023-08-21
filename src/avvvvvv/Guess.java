package avvvvvv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//Number Guessing Game in Java Swing
//Also posted at 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Guess extends JFrame
{
  JTextField input, t2, t3, t4;
  JLabel j4; 
  ButtonListener bl1;
  ButtonListener2 bl2;
  ButtonListener3 bl3;    

 Random r=new Random();
 int rand=r.nextInt(1,100);
 
  int count=0;
  public static void main(String[] args)
  {
      new Guess();
  }

  public Guess()
  {
      
      Container can = getContentPane();

              
      can.setLayout(null);   

      //Set Background Color
      can.setBackground(new Color(128, 0, 64)); 

      //Creating image 
     
      //Creating label Guess my number text
      JLabel j=new JLabel("Number Guessing Game");
      j.setForeground(Color.RED);
      j.setFont(new Font("tunga",Font.BOLD,24));
      j.setSize(301,38);
      j.setLocation(125,11);

      //Creating label Enter a number..... 
      JLabel j1=new JLabel("Enter a number in range 1-100");
      j1.setForeground(new Color(0, 128, 128));
      j1.setFont(new Font("tunga",Font.PLAIN,17));
      j1.setSize(270,20);
      j1.setLocation(147,47);

      //Creating TextField for input guess
      input=new JTextField(10);
      input.setFont(new Font("Tahoma", Font.BOLD, 11));
      input.setBackground(new Color(128, 128, 255));
      input.setSize(192,30);
      input.setLocation(161,75);

      //Creating Label for Display message        
      j4=new JLabel("");
      j4.setForeground(new Color(0, 255, 0));
      j4.setFont(new Font("Dialog", Font.ITALIC, 18));
      j4.setSize(358,41);
      j4.setLocation(86,226);

      //Creating Text field for best score
      t2=new JTextField(10);
      t2.setFont(new Font("Tahoma", Font.BOLD, 17));
      t2.setBackground(new Color(128, 128, 255));
      t2.setEditable(false);
      t2.setSize(83,38);
      t2.setLocation(10,108);        

      //Creating Label for best score
      JLabel j5=new JLabel("Score");
      j5.setFont(new Font("Dialog", Font.BOLD, 17));
      j5.setSize(270,20);
      j5.setLocation(10,78);

      //Creating guess text field
      t3=new JTextField(10);
      t3.setBackground(new Color(128, 128, 255));
      t3.setFont(new Font("Tahoma", Font.BOLD, 13));
      t3.setSize(83,41);
      t3.setLocation(441,100);

      //Creating guess Label
      JLabel j6=new JLabel("Attempt");
      j6.setFont(new Font("Dialog", Font.BOLD, 17));
      j6.setSize(270,20);
      j6.setLocation(445,75);

      //creating 3 buttons
      JButton b1=new JButton("Guess");
      b1.setForeground(new Color(255, 0, 128));
      b1.setFont(new Font("Dialog", Font.BOLD, 14));
      b1.setBackground(new Color(0, 0, 160));
      b1.setSize(108,39);
      b1.setLocation(271,111);
      bl1=new ButtonListener();        
      b1.addActionListener(bl1);


      JButton b2=new JButton("Give up!");
      b2.setForeground(new Color(255, 0, 128));
      b2.setBackground(new Color(0, 0, 160));
      b2.setFont(new Font("Dialog", Font.BOLD, 14));
      b2.setSize(108,38);
      b2.setLocation(125,111);
      bl2=new ButtonListener2();
      b2.addActionListener(bl2);        

      JButton b3=new JButton("Restart");    
      b3.setFont(new Font("Tahoma", Font.BOLD, 14));
      b3.setBackground(new Color(255, 0, 128));
      b3.setSize(137,30);
      b3.setLocation(182,161);    
      bl3=new ButtonListener3();        
      b3.addActionListener(bl3);


      //Place the components in the pane
      can.add(j5);    
      can.add(j4);    
      can.add(j);    
      can.add(j1);
      can.add(input);
      can.add(t2);
      can.add(t3);
      can.add(b1);    
      can.add(b2);
      can.add(b3);        
      can.add(j6);
      t3.setEditable(false);    

      
     
      //Set the size of the window and display it
      setSize(550,350);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private class ButtonListener implements ActionListener
  {
      int bestScore=100;
      public void actionPerformed(ActionEvent e)
      {
    	  
          int a = Integer.parseInt(input.getText());
          if(a>100||a<1) {
        	  j4.setText("Enter valid no in range 1-100");
        	  return;
        	  
          }
         
          count=count+1;
          if( count >=10){
        	 // rand= r.nextInt(1,100);
        	  j4.setText("you lost your max chances the no is "+rand);
        	  input.setEditable(false);
        	  t2.setText("00");
        	  //rand= r.nextInt(1,100);
        	  
          }
          else  if(a<rand)
          {
              j4.setText("Sorry your no:"+a+" is low, try again!!");
          }    
          else if(a>rand)
          {
              j4.setText("sorry your no"+a+" is  high, try again!!");
          }
          else
          {
              j4.setText("CORRECT, YOU WIN!!!!"+ "No is"  +rand);
             
              if(count<bestScore)
              {    
                  bestScore=100-count*10+10;
                  t2.setText(bestScore+"");
              }
              else
                  t2.setText(""+bestScore);
              input.setEditable(false);
          }

          
          t3.setText(count+"");
      }
  }

  private class ButtonListener2 implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          t3.setText("");
          j4.setText(rand+" is the answer!");
          input.setText("");
          input.setEditable(false);
      }
  }        

  private class ButtonListener3 implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
    	  t2.setText("");
          rand= r.nextInt(1,100);
          input.setText("");
          t3.setText("");
          t3.setText("");
          count=0;
          input.setEditable(true);    
        
      }
  }

 
}