package productline;
// Author: Jeff Munoz

/**
 * This class extends the abstract class of product and uses the interface MultiMediaControl. It
 * creates the movie player objects through the use of one constructor, which takes in 4 arguments
 * and calls the super constructor.
 */
public class MoviePlayer extends Product implements MultiMediaControl {
  private Screen screen;
  private MonitorType typeOfMonitor;

  public MonitorType getTypeOfMonitor() {
    return typeOfMonitor;
  }

  public void setTypeOfMonitor(MonitorType typeOfMonitor) {
    this.typeOfMonitor = typeOfMonitor;
  }

  public Screen getScreen() {
    return screen;
  }

  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * * This creates the movie player objects.
   *
   * @param name this is the name of the player object.
   * @param manufacturer this is the name of the manufacturer of the object.
   * @param screen these are the specs of the screen on the object.
   * @param typeOfMonitor the type of monitor the objects has.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType typeOfMonitor) {
    super(name, manufacturer, ItemType.Visual_Mobile);
    this.screen = screen;
    this.typeOfMonitor = typeOfMonitor;
  }

  @Override
  public void play() {
    System.out.println("Playing Movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping Movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous Movie");
  }

  @Override
  public void next() {
    System.out.println("Next Movie");
  }

  @Override
  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + typeOfMonitor;
  }
}
