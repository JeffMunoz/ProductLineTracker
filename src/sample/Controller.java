package sample;

import java.sql.Connection;
import java.sql.DriverManager;
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



  @FXML
  private void handleButtonAction(ActionEvent event) {

    System.out.println("Product Added");
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
