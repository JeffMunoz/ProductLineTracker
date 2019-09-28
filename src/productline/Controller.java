package productline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

// analyze-> inspect code
/**
 * This class handles all the events that user creates from the GUI. This class uses the default
 * constructor as it does not take in a arguments.
 */
// creates a warning that the class can be made "package private" but when changed
// the fxml files creates an error
public class Controller {
  private Statement stmt = null;
  private Connection conn = null;

  @FXML private ComboBox<String> quantityCBox = new ComboBox<>();
  @FXML private TextField prName = new TextField();
  @FXML private TextField manufacturer = new TextField();
  @FXML private TextField type = new TextField();

  /**
   * * This is the start method of the controller, initializes the connection to the data base and
   * populates the combo box.
   */
  public void initialize() {
    // Connection to the database
    // Good place to start tutorialsPoint
    // https://www.tutorialspoint.com/h2_database/h2_database_jdbc_connection.html
    // JDBC driver name and database URL
    final String Jdbc_Driver = "org.h2.Driver";
    final String Db_Url = "jdbc:h2:./res/ProductionDB";
    final String user = "";
    final String pass = "";

    try {
      Class.forName(Jdbc_Driver);
      // uses an empty password for now but it will be addressed at a later time
      conn = DriverManager.getConnection(Db_Url, user, pass);

      stmt = conn.createStatement();
      // Items to be placed in the comboBox
      quantityCBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
      // allows users to edit the contents of the ComboBox
      quantityCBox.getSelectionModel().selectFirst();
      quantityCBox.setEditable(true);

    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
      // e.printStackTrace();
      System.out.println("Error in SQL please try again");
    }
  }

  /**
   * This is action handler that adds products to the data base and obtains the information when the
   * button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void handleButtonAction(ActionEvent event) {
    try {

      // Obtains the input from the text fields
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
      // non constant string used but it will be replaced with a prepared statement later
      stmt.executeUpdate(sqlAdd);
      // System.out.println(sqlAdd);
      String sql = "SELECT * FROM PRODUCT;";
      ResultSet rs = stmt.executeQuery(sql);
      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();

      // These loops are used to out put the table of data to the console
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
      stmt.close();
      conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * This is action handler that outputs to the console when the button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void goodByeBtn(ActionEvent event) {
    System.out.println("Production Recorded");
  }

  /**
   * This is action handler that outputs to the console when the button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void welcomeBtn(ActionEvent event) {
    System.out.println("Hello World!");
  }
}
