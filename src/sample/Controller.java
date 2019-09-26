package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.xml.soap.Text;

// analyze-> inspect code
public class Controller {
  Statement stmt = null;
  Connection conn = null;
  @FXML private ComboBox<String> cBox = new ComboBox<>();
  @FXML private TextField prName = new TextField();
  @FXML private TextField Manufacturer  = new TextField();
  @FXML private TextField type = new TextField();


  public void initialize() {
    // Connection to the database
    // Good place to start tutorialsPoint
    // https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.html
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductionDB";
    final String USER = "";
    final String PASS = "";



    try {
      Class.forName(JDBC_DRIVER);

      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
      cBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
      cBox.getSelectionModel().selectFirst();
      cBox.setEditable(true);


    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
        e.printStackTrace();
//      System.out.println("Error in SQL please try again");
    }
  }

  @FXML
  private void handleButtonAction(ActionEvent event) {
    try {

      String newProductName = prName.getText();
      String newProductMan = Manufacturer.getText();
      String newProductType = type.getText();
     // String sqlAdd = "INSERT INTO Product(type, manufacturer, name) VALUES ("+ newProductType +','+newProductMan
    //+"," +newProductName +");";
     // stmt.executeUpdate(sqlAdd);
      //System.out.println(sqlAdd);
      String sql = "SELECT * FROM PRODUCT;";
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();
      boolean b = rsmd.isSearchable(1);
      for(int i = 1;i <= numberOfColumns; i++ ){
        System.out.print(rsmd.getColumnName(i) + "\t");
      }
      System.out.println(" ");
      while (rs.next()) {
        for(int i = 1; i <= numberOfColumns; i++){
          System.out.print(rs.getString(i) + "\t ");
        }
        System.out.println(" ");
      }

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
