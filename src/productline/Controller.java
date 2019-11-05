package productline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
  @FXML private ChoiceBox<ItemType> cbType;
  @FXML private TableView currentProducts = new TableView();
  @FXML private ListView produceList = new ListView();
  @FXML private TableView currentLog = new TableView();
  @FXML private Button deleteButton = new Button();
  final ArrayList<Product> arrOfProducts = new ArrayList();
  ObservableList<Product> products;
  private int audioCount = 0;
  private int audioMobileCount = 0;
  private int visualMobileCount = 0;
  private int visualCount = 0;
  /**
   * * This is the start method of the controller, initializes the connection to the data base and
   * populates the combo box.
   */
  public void initialize() {

    products = FXCollections.observableList(arrOfProducts);
    // Items to be placed in the comboBox
    quantityCBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    // allows users to edit the contents of the ComboBox
    quantityCBox.getSelectionModel().selectFirst();
    quantityCBox.setEditable(true);

    // Populates the choice box with the type of items form the enum
    for (ItemType typeOfItem : ItemType.values()) {
      cbType.getItems().add(typeOfItem);
    }

    TableColumn<Product, Integer> idNumber = new TableColumn<>(" ID");
    idNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
    TableColumn<Product, String> currentName = new TableColumn<>("Name");
    currentName.setCellValueFactory(new PropertyValueFactory<>("name"));
    TableColumn<Product, String> currentManufacturer = new TableColumn<>("Manufacturer");
    currentManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    TableColumn<Product, String> currentType = new TableColumn<>("Type");
    currentType.setCellValueFactory(new PropertyValueFactory<>("type"));

    currentProducts.getColumns().add(idNumber);
    currentProducts.getColumns().add(currentName);
    currentProducts.getColumns().add(currentManufacturer);
    currentProducts.getColumns().add(currentType);

    TableColumn<ProductionRecord, Integer> productionNum = new TableColumn<>(" Production Number");
    productionNum.setCellValueFactory(new PropertyValueFactory<>("productionNumber"));
    TableColumn<ProductionRecord, Integer> productIdNum = new TableColumn<>("Product ID");
    productIdNum.setCellValueFactory(new PropertyValueFactory<>("productId"));
    TableColumn<ProductionRecord, String> serialNumber = new TableColumn<>("Serial Number");
    serialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
    TableColumn<ProductionRecord, Date> dateProduced = new TableColumn<>(" Date");
    dateProduced.setCellValueFactory(new PropertyValueFactory<>("dateProduct"));

    currentLog.getColumns().add(productionNum);
    currentLog.getColumns().add(productIdNum);
    currentLog.getColumns().add(serialNumber);
    currentLog.getColumns().add(dateProduced);

    populateTable();
    populateProductionLog();
  }

  /**
   * This is action handler that adds products to the data base and obtains the information when the
   * button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void handleButtonAction(ActionEvent event) {
    initializeDB();
    try {
      // non constant string replaced with a prepared statement
      String preparedStm = "INSERT INTO Product(name, manufacturer, type) VALUES ( ?, ?, ? );";
      PreparedStatement preparedStatement = conn.prepareStatement(preparedStm);
      // adds the parameters to the preparedStatement
      preparedStatement.setString(1, prName.getText());
      preparedStatement.setString(2, manufacturer.getText());
      preparedStatement.setString(3, cbType.getValue().code);

      preparedStatement.executeUpdate();
      populateTable();

      preparedStatement.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDb();
  }

  /**
   * This is action handler that outputs to the console when the button is clicked.
   *
   * @param event this detects when the button is clicked.
   */
  @FXML
  private void produceBtn(ActionEvent event) {
    initializeDB();
    try {
      // non constant string replaced with a prepared statement
      String preparedStm = "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES ( ?,?, ?);";
      PreparedStatement preparedStatement = conn.prepareStatement(preparedStm);
      // adds the parameters to the preparedStatement
      Product listProduct = (Product) produceList.getSelectionModel().getSelectedItem();
      int countNum = Integer.parseInt(quantityCBox.getSelectionModel().getSelectedItem());
      Date tempDate = new Date();
      java.sql.Timestamp sqlDate = new java.sql.Timestamp(tempDate.getTime());
      for (int productionRunProduct = 0; productionRunProduct < countNum; productionRunProduct++) {
        if (listProduct.getType().code.equals("AU")) {
          ProductionRecord recodedProduction = new ProductionRecord(listProduct, audioCount++);
          preparedStatement.setInt(1, listProduct.getId());
          preparedStatement.setString(2, recodedProduction.getSerialNumber());
          preparedStatement.setTimestamp(3,sqlDate);
          preparedStatement.executeUpdate();
        } else if (listProduct.getType().code.equals("VI")) {
          ProductionRecord recodedProduction = new ProductionRecord(listProduct, visualCount++);
          preparedStatement.setInt(1, listProduct.getId());
          preparedStatement.setString(2, recodedProduction.getSerialNumber());
          preparedStatement.setTimestamp(3,sqlDate);
          preparedStatement.executeUpdate();
        } else if (listProduct.getType().code.equals("AM")) {
          ProductionRecord recodedProduction =
              new ProductionRecord(listProduct, audioMobileCount++);
          preparedStatement.setInt(1, listProduct.getId());
          preparedStatement.setString(2, recodedProduction.getSerialNumber());
          preparedStatement.setTimestamp(3,sqlDate);
          preparedStatement.executeUpdate();
        } else {
          ProductionRecord recodedProduction =
              new ProductionRecord(listProduct, visualMobileCount++);
          preparedStatement.setInt(1, listProduct.getId());
          preparedStatement.setString(2, recodedProduction.getSerialNumber());
          preparedStatement.setTimestamp(3,sqlDate);
          preparedStatement.executeUpdate();
        }
      }

      populateProductionLog();
      preparedStatement.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDb();
    System.out.println("Production Recorded");
  }

  /** This method will delete the selected product from the database*/
  public void deleteProduct() {
    initializeDB();
    try {
      Product productToBeDeleted = (Product) currentProducts.getSelectionModel().getSelectedItem();
      int delete = productToBeDeleted.getId();
      String preparedStm = "DELETE FROM PRODUCT WHERE ID = ?;";
      PreparedStatement preparedStatement = null;
      preparedStatement = conn.prepareStatement(preparedStm);
      preparedStatement.setInt(1, delete);
      preparedStatement.executeUpdate();
      ObservableList<Product> allProducts = currentProducts.getItems();
      ObservableList<Product> selectedProduct = currentProducts.getSelectionModel()
          .getSelectedItems();
      selectedProduct.forEach(allProducts::remove);

      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    populateTable();
    closeDb();
  }

  /** This method populates the table view in the GUI. */
  public void populateTable() {
    initializeDB();
    String sql = "SELECT * FROM PRODUCT;";
    ResultSet rs;
    arrOfProducts.clear();
    products.clear();
    produceList.getItems().clear();
    try {
      rs = stmt.executeQuery(sql);
      // This loop is used to out put the table of data to the table view
      while (rs.next()) {
        String name = rs.getString("Name");
        String manufacturer = rs.getString("Manufacturer");
        String typeCode = rs.getString("Type");
        int itemId = rs.getInt("ID");
        ItemType type;
        switch (typeCode) {
          case "AU":
            type = ItemType.Audio;
            break;
          case "VI":
            type = ItemType.Visual;
            break;
          case "AM":
            type = ItemType.Audio_Mobile;
            break;
          default:
            type = ItemType.Visual_Mobile;
        }
        Product tempProduct = new Widget(name, manufacturer, type, itemId);
        arrOfProducts.add(tempProduct);
        produceList.getItems().add(tempProduct);
      }
      products = FXCollections.observableList(arrOfProducts);
      currentProducts.setItems(products);

    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDb();
  }

  /**
   * This method populates the text area in the GUI using the information from production record.
   */
  public void populateProductionLog() {
    final ArrayList<ProductionRecord> recordsList = new ArrayList();
    ObservableList<ProductionRecord> records = FXCollections.observableList(recordsList);
    initializeDB();
    recordsList.clear();
    records.clear();
    try {
      String sqlRecord = "SELECT * FROM PRODUCTIONRECORD;";
      ResultSet results;
      results = stmt.executeQuery(sqlRecord);
      while (results.next()) {
        ProductionRecord tempRecord =
            new ProductionRecord(
                results.getInt("Production_Num"),
                results.getInt("Product_ID"),
                results.getString("Serial_Num"),
                results.getDate("Date_Produced"));
        // This reads what is the database and increases the counts of the type of objects created
        if (tempRecord.getSerialNumber().substring(3, 5).equals("AU")) {
          audioCount++;
        } else if (tempRecord.getSerialNumber().substring(3, 5).equals("VI")) {
          visualCount++;
        } else if (tempRecord.getSerialNumber().substring(3, 5).equals("AM")) {
          audioMobileCount++;
        } else {
          visualMobileCount++;
        }
        recordsList.add(tempRecord);
      }
      records = FXCollections.observableList(recordsList);
      currentLog.setItems(records);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDb();
  }

  public void initializeDB() {
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
    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error in SQL please try again");
    }
  }

  public void closeDb() {
    try {
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
