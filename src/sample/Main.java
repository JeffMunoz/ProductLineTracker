package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** @author Jeffry Munoz.
 *  @breif To demonstrate the usage of Javafx and dataBases */
public class Main extends Application {

  /**
   * * This is the start method of the Javafx program.
   * @breif This creates the stage for the GUI
   * @param primaryStage This a primary stage
   * @throws Exception Causes an exception to be thrown and caught else where to avoid crashing.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Production Line");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
