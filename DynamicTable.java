import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DynamicTable implements ActionListener {
    JFrame f;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    JLabel jl4;
    JButton jb1;
    JButton jb2;
    JButton jb3;

    JTextField jt1;
    JTextField jt2;
    JTextField jt3;
    JComboBox types;
    String[] typeList = { "VARCHAR", "NUMBER", "INTEGER", "SMALLINT", "BIGINT", "BOOLEAN", "REAL", "FLOAT", "DATE",
            "TIME" };
    static int i = 1;
    StringBuffer sb = new StringBuffer("CREATE TABLE ");

    DynamicTable() {
        f = new JFrame("Dynamic Table");
        jl1 = new JLabel("Table");
        jl1.setBounds(20, 40, 80, 20);
        f.add(jl1);
        jl2 = new JLabel("Field");
        jl2.setBounds(20, 80, 80, 20);
        f.add(jl2);
        jl3 = new JLabel("Type");
        jl3.setBounds(20, 120, 80, 20);
        f.add(jl3);
        jl4 = new JLabel("Size");
        jl4.setBounds(20, 160, 80, 20);
        f.add(jl4);

        jb1 = new JButton("Add");
        jb1.setBounds(50, 250, 80, 20);
        f.add(jb1);
        jb1.addActionListener(this);
        jb2 = new JButton("Cancel");
        jb2.setBounds(150, 250, 80, 20);
        f.add(jb2);
        jb2.addActionListener(this);
        jb3 = new JButton("Build the Table");
        jb3.setBounds(75, 300, 130, 30);
        f.add(jb3);
        jb3.addActionListener(this);

        jt1 = new JTextField();
        jt1.setBounds(80, 40, 80, 20);
        f.add(jt1);
        jt2 = new JTextField();
        jt2.setBounds(80, 80, 80, 20);
        f.add(jt2);
        types = new JComboBox(typeList);
        types.setBounds(80, 120, 100, 20);
        // types.addItemListener(new );
        f.add(types);
        jt3 = new JTextField();
        jt3.setBounds(80, 160, 80, 20);
        f.add(jt3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(300, 400);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            if (i == 1) {
                sb.append(jt1.getText() + "(");
                sb.append(jt2.getText() + " ");
            } else {
                sb.append("," + jt2.getText() + " ");
            }
            sb.append(String.valueOf(types.getSelectedItem()));
            sb.append("(" + jt3.getText() + ")");
            jt2.setText("");
            jt3.setText("");
            System.out.println(sb);
            i++;
        }
        if (e.getSource() == jb2) {
            sb = new StringBuffer();
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
            i = 1;
            sb = new StringBuffer("CREATE TABLE ");
        }
        if (e.getSource() == jb3) {
            sb.append(")");
            try {
                // Class.forName("oracle.jdbc.driver.OracleDriver");
                // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                //         "Hello123");
                
                Statement stmt = conn.createStatement();
                stmt.execute(String.valueOf(sb));
                System.out.println(sb);
                jt2.setText("");
                jt3.setText("");
                System.out.println("Table Created Successfully");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String args[]) {
        new DynamicTable();
    }
}