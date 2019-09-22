package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jeffry Munoz
 */

public class Main extends Application {

    /**
     **
     * This is the start method of the Javafx program
     * @breif
     * @param primaryStage This a primary stage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
      // Some code obtained from tutorialsPoint https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.htm
      // JDBC driver name and database URL
      final String JDBC_DRIVER = "org.h2.Driver";
      final String DB_URL = "jdbc:h2:~/test";
      final String USER = "";
      final String PASS = "";


      Connection conn = null;
      Statement stmt = null;

      try {
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        stmt = conn.createStatement();
        String sqlStmt = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'Weapon', 'Tediore ', 'The Boo+' );";
        stmt.execute(sqlStmt);

        stmt.close();
        conn.close();

      } catch (ClassNotFoundException e) {
        //e.printStackTrace();
        System.out.println("Unable to find class");
      }
      catch(SQLException e) {
        System.out.println("Error in SQL please try again");
      }


    }

}
