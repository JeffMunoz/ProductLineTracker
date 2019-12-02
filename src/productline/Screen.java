package productline;
/**
 * This class uses the interface ScreenSpec. It creates the screen objects through the use of one
 * constructor, which takes in 3 arguments.
 *
 * @author Jeffry Munoz
 */
public class Screen implements ScreenSpec {
  private final String resolution;
  private final int refreshRate;
  private final int responseTime;

  /**
   * This creates the screen objects.
   *
   * @param resolution this is the resolution of the display.
   * @param refreshRate this is an int value that represents how fast the screen refreshes.
   * @param responseTime this is how fast the screen responds.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }

  @Override
  public String toString() {
    return "Screen: "
        + "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshRate
        + "\n"
        + "Response time: "
        + responseTime;
  }
}
