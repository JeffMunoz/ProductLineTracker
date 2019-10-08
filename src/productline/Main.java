package productline;

import static productline.MonitorType.LCD;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This program sets up a basic GUI and connects to a data base that allows users to add products to
 * the database.
 *
 * @author Jeffry Munoz.
 */
public class Main extends Application {

  /**
   * * This is the start method of the Javafx program.
   *
   * @param primaryStage This a primary stage
   * @throws Exception Causes an exception to be thrown and caught else where to avoid crashing.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("product.fxml"));
    primaryStage.setTitle("Production Line");
    primaryStage.setScene(new Scene(root, 650, 500));
    primaryStage.show();

    AudioPlayer testAudio = new AudioPlayer("beats", "dre", ".WAV", "Test");
    System.out.println(testAudio);
    Screen testScreen = new Screen("1080x720", 60, 2);
    System.out.println(testScreen);

   MoviePlayer testMoviePlayer = new MoviePlayer("Blue Ray","Sony", "720x480", LCD);
    System.out.println(testMoviePlayer);
  }

  /**
   * * This is the driver class of the program.
   *
   * @param args this is the input array of strings to be used in the program
   */
  public static void main(String[] args) {
    launch(args);
  }
}
