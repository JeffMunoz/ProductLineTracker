package productline;

/**
 * This class extends the abstract class of product and uses the interface MultiMediaControl. It
 * creates the audio player objects through the use of one constructor, which takes in 4 arguments
 * and calls the super constructor.
 *
 * @author Jeffry Munoz
 */
public class AudioPlayer extends Product implements MultiMediaControl {
  private String supportedAudioFormats;
  private String supportedPlaylistFormats;

  /**
   * * This creates the audio player objects.
   *
   * @param name this is the name of the player object.
   * @param manufacturer this is the name of the manufacturer of the object.
   * @param supportedAudioFormats these are the possible audio formats the object can replay.
   * @param supportedPlaylistFormats these are the playList formats
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.Audio);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  public String getSupportedAudioFormats() {
    return supportedAudioFormats;
  }

  public String getSupportedPlaylistFormats() {
    return supportedPlaylistFormats;
  }

  public void setSupportedAudioFormats(String supportedAudioFormats) {
    this.supportedAudioFormats = supportedAudioFormats;
  }

  public void setSupportedPlaylistFormats(String supportedPlaylistFormats) {
    this.supportedPlaylistFormats = supportedPlaylistFormats;
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
        + "Supported Audio Formats: "
        + supportedAudioFormats
        + "\n"
        + "Supported Playlist Formats: "
        + supportedPlaylistFormats;
  }
}
