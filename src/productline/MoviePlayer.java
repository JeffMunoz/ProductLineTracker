package productline;
// Author: Jeff Munoz
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

  public MoviePlayer(
      String name,
      String manufacturer,
      Screen screen,
      MonitorType typeOfMonitor) {
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
    return super.toString()
        + "\n"
        + screen
        + "\n"
        + "Monitor Type: "
        + typeOfMonitor;
  }
}
