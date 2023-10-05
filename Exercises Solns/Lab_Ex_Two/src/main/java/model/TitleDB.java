package model;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan.Ryan
 */
public class TitleDB {

    static Connection connection;
    static QueryRunner runner;

    public static void connectToDB() {
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connect to DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
            //create runner
            runner = new QueryRunner();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }//end connectToDB() 

    public static void disconnectFromDB() {
        try {
            DbUtils.close(connection);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//end disconnectFromDB

    public static List<Title> getAllTitles() {

        List<Title> list = new ArrayList();

        //my handler will convert rows in the ResultSet to Title objects and place them in a list
        ResultSetHandler<List<Title>> handler = new BeanListHandler(Title.class);

        try {
            //execute the query and populate the list
           list = runner.query(connection, "SELECT * FROM titles", handler);
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
        }

        return list;
    }
}
