package productline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// Author: Jeff Munoz
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
  @FXML private ChoiceBox type = new ChoiceBox();
  @FXML private TableView currentProducts = new TableView();

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

      // Populates the choice box with the type of items form the enum
      for (ItemType typeOfItem : ItemType.values()) {
        type.getItems().add(typeOfItem);
      }

      TableColumn<String, Product> currentName = new TableColumn<>("Name");
      currentName.setCellValueFactory(new PropertyValueFactory<>("name"));
      TableColumn<String, Product> currentManufacturer = new TableColumn<>("Manufacturer");
      currentManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
      TableColumn<String, Product> currentType = new TableColumn<>("Type");
      currentType.setCellValueFactory(new PropertyValueFactory<>("Type"));

      currentProducts.getColumns().add(currentName);
      currentProducts.getColumns().add(currentManufacturer);
      currentProducts.getColumns().add(currentType);

    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
      e.printStackTrace();
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
      String newProductType = String.valueOf(type.getSelectionModel().getSelectedItem());
      String preparedStm = "INSERT INTO Product(type, manufacturer, name) VALUES ( ?, ?, ? );";
      PreparedStatement preparedStatement = conn.prepareStatement(preparedStm);
      preparedStatement.setString(1, newProductType);
      preparedStatement.setString(2, newProductMan);
      preparedStatement.setString(3, newProductName);
      // non constant string replaced with a prepared statement
      preparedStatement.executeUpdate();
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
          currentProducts.getItems().add(rs.getString(i));
        }
        System.out.println(" ");
      }

      preparedStatement.close();
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
  private void produceBtn(ActionEvent event) {
    System.out.println("Production Recorded");
  }

  /**
   * This is action handler that outputs to the console when the button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void logBtn(ActionEvent event) {
    System.out.println("Hello World!");
  }
}
