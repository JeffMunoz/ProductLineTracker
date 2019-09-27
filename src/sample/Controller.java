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
  @FXML private ComboBox<String> quantityCBox = new ComboBox<>();
  @FXML private TextField prName = new TextField();
  @FXML private TextField manufacturer = new TextField();
  @FXML private TextField type = new TextField();


  /**
   * * This is the start method of the controller.
   * @breif  initializes the connection to the data base and populates the combo box
   * @throws Exception Causes an exception to be thrown if there is an issue with the Data base
   *         connection.
   */
  public void initialize() {
    // Connection to the database
    // Good place to start tutorialsPoint
    // https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.html
    // JDBC driver name and database URL
    final String Jdbc_Driver = "org.h2.Driver";
    final String Db_Url = "jdbc:h2:./res/ProductionDB";
    final String user = " ";
    final String pass = " ";

    try {
      Class.forName(Jdbc_Driver);

      conn = DriverManager.getConnection(Db_Url, user, pass);

      stmt = conn.createStatement();
      quantityCBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
      quantityCBox.getSelectionModel().selectFirst();
      quantityCBox.setEditable(true);

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
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
      String newProductMan = manufacturer.getText();
      String newProductType = type.getText();
      String sqlAdd =
          "INSERT INTO Product(type, manufacturer, name) VALUES ("
              + " ' "
              + newProductType
              + " ' "
              + ','
              + "'"
              + newProductMan
              + "'"
              + ","
              + "'"
              + newProductName
              + "'"
              + ");";
      stmt.executeUpdate(sqlAdd);
      // System.out.println(sqlAdd);
      String sql = "SELECT * FROM PRODUCT;";
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();

      for (int i = 1; i <= numberOfColumns; i++) {
        System.out.print(rsmd.getColumnName(i) + "\t");
      }
      System.out.println(" ");
      while (rs.next()) {
        for (int i = 1; i <= numberOfColumns; i++) {
          System.out.print(rs.getString(i) + "\t ");
        }
        System.out.println(" ");
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void goodByeBtn(ActionEvent event) {
    System.out.println("Production Recorded");
  }

  @FXML
  private void welcomeBtn(ActionEvent event) {
    System.out.println("General Kenobi!");
  }
}
