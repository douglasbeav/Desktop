import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statements {
    //    Declare a Statement
    private static Statement stmt = null;

    //    Declare & create a connection
    private static Connection con = DB_Connector.connect();

    //    Declare a result set
    private static ResultSet rs = null;


    //    Method to create a new Database
    public void createDB() {

//    SQL statement
        String query = "create database if not exists ThisDatabase";
        try {

//    create statement
            stmt = con.createStatement();

//    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Database was created--");
        }

//    handle sql exceptions
        catch (SQLException ex) {
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }

    }

    //    method to use a database
    public void useDB() {


//    SQL statement
        String query = "use ThisDatabase";
        try {

//    create statement
            stmt = con.createStatement();

//    execute statement
            stmt.executeUpdate(query);
        }
//    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }

}

//    method to create a table
    public void createTable() {

//    SQL statement
        String query = "create table if not exists ThisTable(" +
                "id int not null auto_increment," +
                "name varchar(28)," +
                "address varchar(28)" +
                ")";
        try {

//    create statement
            stmt = con.createStatement();

//    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Table created--");
        }

//    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n--Statement did not execute");
            ex.printStackTrace();
        }
    }

//    method to insert data
    public void insertData() {

//    SQL statement
        String query = "insert into ThisTable " +
                "(name, address) " +
                "values ('Douglas', 'Home'), " +
                "('John', 'At Home'), " +
                "('Bobby', His Home')";
        try {

//    create statement
            stmt =con.createStatement();

//    execute statement
            stmt.executeUpdate(query);
            System.out.println("\n--Data inserted--");
        }

//    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }

//    method to read data from table
    public void queryThisTable() {

//    SQL statement
        String query = "select * from ThisTable";

        try {
//    create statement
            stmt = con.createStatement();

//    execute statement
            rs = stmt.executeQuery(query);
            System.out.println("\nid\t\tname\t\taddress\n_______________________________________");

//            return next row in the table while true
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String address = rs.getString("address");

            }
            System.out.println("\n--Query was executed--");
        }

//    handle sql exceptions
        catch(SQLException ex) {
            System.out.println("\n--Statement did not execute--");
            ex.printStackTrace();
        }
    }
}
