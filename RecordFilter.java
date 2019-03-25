import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RecordFilter
{
    JFrame f;
    JTextField tf;
    JLabel l;
   

    
    //String items[][]={{}};
    
    RecordFilter(String s)
    {
        f=new JFrame(s);

        l=new JLabel("Enter eid/Phone");
        l.setBounds(40,40,125,25);
        f.add(l);

        
        


        tf=new JTextField();
        tf.setBounds(170,40,350,25);
        f.add(tf);

        tf.addKeyListener(new KeyEventListener(this));

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        new RecordFilter("Record Filter");               
    }
}

class KeyEventListener extends KeyAdapter
{
    RecordFilter r;
    KeyEventListener(RecordFilter t)
    {
        this.r=t;
    }

    public void keyTyped(KeyEvent e)
    {
        String filter=r.tf.getText()+e.getKeyChar();
        System.out.println(filter);
    
        String[] heading={"eid","ename","salary","phone"};
        String items[][]=new String[100][4];
        int i=0;
        

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl","root","PASSWORD");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Employee");
            while(rs.next())
            {
                if(rs.getString(1).startsWith(filter) || rs.getString(4).startsWith(filter))
                {
                        items[i][0]=rs.getString(1);
                        items[i][1]=rs.getString(2);
                        items[i][2]=rs.getString(3);
                        items[i][3]=rs.getString(4);
                        i++;                    
                }
            }
        }
        catch(Exception ex){System.out.println(ex);}
        
        JTable jt=new JTable(items,heading);        
        JScrollPane jp=new JScrollPane(jt);
        jp.setBounds(40,75,500,200);
        r.f.add(jp);
    }
}