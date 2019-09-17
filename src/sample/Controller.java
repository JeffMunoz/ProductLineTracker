package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

// analyze-> inspect code
public class Controller {


  @FXML
  private void handleButtonAction(ActionEvent event) {
    System.out.println("Hello World!");
  }
  @FXML
  private void goodByeBTN(ActionEvent event) {
    System.out.println("Good-Bye World!");
  }

  @FXML
  private void welcomeBTN(ActionEvent event) {
    System.out.println("General Kenobi!");
  }
}
