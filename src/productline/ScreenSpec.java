package productline;

/**
 * This Interface declares the methods needed to obtain the screen specifications.
 *
 * @author Jeffry Munoz
 */
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
