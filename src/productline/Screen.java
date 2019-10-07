package productline;

public class Screen implements ScreenSpec {
  private String resolution;
  private int refreshRate;
  private int responseTime;

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
  public String toString(){
    return super.toString();
  }
}
