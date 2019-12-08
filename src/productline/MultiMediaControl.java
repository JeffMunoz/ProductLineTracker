package productline;
/**
 * This Interface has the basic controls that all multimedia devices share.
 *
 * @author Jeffry Munoz
 */ //Use of formatter causes issues with checkStyle

public interface MultiMediaControl {

  void play();

  void stop();

  void previous();

  void next();
}
