import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class RecordScroll 
{
    JFrame f;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    JLabel jl4;
    JLabel jl5;
    JTextArea jt1;
    JTextArea jt2;
    JTextArea jt3;
    JTextArea jt4;
    JScrollBar jBar;
    static int totalRows;

    
    
    RecordScroll()
    {
        f=new JFrame();

        jl1=new JLabel("eid");
        jl1.setBounds(20,20,40,20);
        f.add(jl1);
        jl2=new JLabel("name");
        jl2.setBounds(20,50,40,20);
        f.add(jl2);
        jl3=new JLabel("salary");
        jl3.setBounds(20,80,40,20);
        f.add(jl3);
        jl4=new JLabel("phone");
        jl4.setBounds(20,110,40,20);
        f.add(jl4);
        jl5=new JLabel("");
        jl5.setBounds(20,350,20,30);
        f.add(jl5);

        jt1=new JTextArea();
        jt1.setBounds(100,20,100,20);
        f.add(jt1);
        jt2=new JTextArea();
        jt2.setBounds(100,50,100,20);
        f.add(jt2);
        jt3=new JTextArea();
        jt3.setBounds(100,80,100,20);
        f.add(jt3);
        jt4=new JTextArea();
        jt4.setBounds(100,110,100,20);
        f.add(jt4);

        jBar=new JScrollBar(JScrollBar.HORIZONTAL);
        jBar.setBounds(20,380,380,20);
        // jBar.setMaximum(totalRows);
        jBar.setMaximum(25);
        // jBar.setMinimum(0);
        jBar.addAdjustmentListener(new CustomAdjustmentListener(this));
        f.add(jBar);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
    }

    public static void main(String args[])
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl","root","Mysql123");
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1=stmt.executeQuery("select * from Emp");
            rs1.last();
            totalRows=rs1.getRow();
            // System.out.println(totalRows);
            
            new RecordScroll();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
}


class CustomAdjustmentListener implements AdjustmentListener
{
    RecordScroll rs;
    
    CustomAdjustmentListener(RecordScroll rs)
    {
        this.rs=rs;
    }
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        int row=e.getValue();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/orcl","root","Mysql123");
            Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1=stmt.executeQuery("select * from Emp");
            rs1.absolute(row);
            rs.jt1.setText(rs1.getString(1));
            rs.jt2.setText(rs1.getString(2));
            rs.jt3.setText(rs1.getString(3));
            rs.jt4.setText(rs1.getString(4));
            rs.jl5.setText(String.valueOf(row)+"/"+RecordScroll.totalRows);
            
            rs1.beforeFirst();
        }
        catch(Exception ex){
            rs.jt1.setText("");
            rs.jt2.setText("");
            rs.jt3.setText("");
            rs.jt4.setText("");
            rs.jl5.setText("");
        }
        
    }
}