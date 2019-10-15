package productline;
// Author: Jeff Munoz
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
