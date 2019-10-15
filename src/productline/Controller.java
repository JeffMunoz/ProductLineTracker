package productline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// Author: Jeff Munoz
// analyze-> inspect code
// jfoenix FOR CSS
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
  @FXML private ChoiceBox<ItemType> cbType = new ChoiceBox();
  @FXML private TableView currentProducts = new TableView();
  @FXML private TextArea ta = new TextArea();

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
      ta.clear();

      // Populates the choice box with the type of items form the enum
      for (ItemType typeOfItem : ItemType.values()) {
        cbType.getItems().add(typeOfItem);
      }

      TableColumn<Product, String> currentName = new TableColumn<>("Name");
      currentName.setCellValueFactory(new PropertyValueFactory<>("name"));
      TableColumn<Product, String> currentManufacturer = new TableColumn<>("Manufacturer");
      currentManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
      TableColumn<Product, String> currentType = new TableColumn<>("Type");
      currentType.setCellValueFactory(new PropertyValueFactory<>("type"));

      currentProducts.getColumns().add(currentName);
      currentProducts.getColumns().add(currentManufacturer);
      currentProducts.getColumns().add(currentType);
      populateTable();

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
      ItemType newProductType =  cbType.getValue();
      // creates a widget object to store in the database
      Widget newProduct = new Widget(newProductName, newProductMan, newProductType);
      // non constant string replaced with a prepared statement
      String preparedStm = "INSERT INTO Product(name, manufacturer, type) VALUES ( ?, ?, ? );";
      PreparedStatement preparedStatement = conn.prepareStatement(preparedStm);
      // adds the parameters to the preparedStatement
      preparedStatement.setString(1, newProduct.getName());
      preparedStatement.setString(2, newProduct.getManufacturer());
      preparedStatement.setString(3, newProductType.code);

      preparedStatement.executeUpdate();
      populateTable();

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

  public void populateTable() {
    String sql = "SELECT * FROM PRODUCT;";
    ResultSet rs = null;
    try {
      rs = stmt.executeQuery(sql);

      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();

      ArrayList arrOfProducts = new ArrayList();
      // These loops are used to out put the table of data to the table view
      while (rs.next()) {
        String name = rs.getString("Name");
        String manufacturer = rs.getString("Manufacturer");
        String typeCode = rs.getString("Type");
        ItemType type;
        switch (typeCode){
          case "AU":
              type = ItemType.Audio;
              break;
          case "VI":
            type = ItemType.Visual;
            break;
          case "AM":
            type = ItemType.Audio_Mobile;
          default:
            type = ItemType.Visual_Mobile;
        }
        Product tableProducts = new Widget(name, manufacturer, type);
        arrOfProducts.add(tableProducts);
      }

      ObservableList products = FXCollections.observableList(arrOfProducts);
      currentProducts.setItems(products);

      // This adds to the production record Text area
      for (int i = 1; i <= numberOfColumns; i++) {
        ta.appendText(rsmd.getColumnName(i) + "\t");
      }
      ta.appendText("\n");
      while (rs.next()) {

        for (int i = 1; i <= numberOfColumns; i++) {

          ta.appendText(rs.getString(i) + "\t");
        }
        ta.appendText("\n");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
