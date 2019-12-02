package productline;

/**
 * This enum class contains the available item types.
 *
 * @author Jeffry Munoz
 */
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  Audio_Mobile("AM"),
  Visual_Mobile("VM");

  public final String code;

  ItemType(String code) {
    this.code = code;
  }
}
