package productline;

public class MoviePlayer extends Product implements MultiMediaControl {
  private String screen;
  private MonitorType typeOfMonitor;

  public MonitorType getTypeOfMonitor() {
    return typeOfMonitor;
  }

  public void setTypeOfMonitor(MonitorType typeOfMonitor) {
    this.typeOfMonitor = typeOfMonitor;
  }

  public String getScreen() {
    return screen;
  }

  public void setScreen(String screen) {
    this.screen = screen;
  }



  public MoviePlayer(
      String name,
      String manufacturer,
      String screen,
      MonitorType typeOfMonitor) {
    super(name, manufacturer, "Visual_Mobile");
    this.screen = screen;
    this.typeOfMonitor = typeOfMonitor;

  }


  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public String toString() {
    return super.toString()
        + "\n"
        + "Screen: "
        + screen
        + "\n"
        + "Monitor Type: "
        + typeOfMonitor;
  }
}
