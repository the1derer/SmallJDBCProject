# SmallJDBCProjects
This is a collection of small GUI tools to demonstrate interaction with Database using JDBC

## First create a Database using MySQL Command-Line
1. ``mysql -u root -p``
2. ``mysql> CREATE DATABASE orcl;``

## To compile run following command:
1. In Files DynamicTable.java, RecordFilter.java and RecordScroll.java replace PASSWORD by your MySQL Password 
   in the line
   ```java
   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASE","root","PASSWORD");
   ```

2. ``export CLASSPATH=.:mysql-connector-java-8.0.12.jar``
   
## To Use tools

## Use DynamicTable to create a Table in database using GUI
1. ``javac DynamicTable.java``
2. ``java DynamicTable``
3. Fill the Table Name(name it "Employee"),Field, Type and size
4. Use Add button to add the field
5. Now it will set the<br />
    Table name<br /> 
    fill the another field(s)<br/>
        (i) eid<br />
        (ii) name<br />
        (iii) salary<br />
        (iv) Phone<br />
6. Use Cancel to exit adding the current table.
7. use MySQL CLI to add value to the fields.

## Use RecordScroll to scroll through the created table
1. ``javac RecordScroll.java``
2. ``java RecordScroll``
   
## Use RecordFilter to filter the result based on eid or Phone
1. ``javac RecordFilter.java``
2. ``java RecordFilter``

   
