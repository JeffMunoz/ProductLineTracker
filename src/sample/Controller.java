package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// analyze-> inspect code
public class Controller {
  Statement stmt = null;

  public void initialize() {
    // Connection to the database
    // Good place to start tutorialsPoint
    // https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.html
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";
    final String USER = "";
    final String PASS = "";

    Connection conn = null;

    try {
      Class.forName(JDBC_DRIVER);

      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();

    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
      System.out.println("Error in SQL please try again");
    }
  }

  @FXML
  private void handleButtonAction(ActionEvent event) {
    try {
      String sql = "SELECT * FROM PRODUCT ";
      ResultSet rs = stmt.executeQuery(sql);
      System.out.println("Product Added");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void goodByeBTN(ActionEvent event) {
    System.out.println("Production Recorded");
  }

  @FXML
  private void welcomeBTN(ActionEvent event) {
    System.out.println("General Kenobi!");
  }
}
