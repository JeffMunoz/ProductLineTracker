package productline;
// Author: Jeff Munoz

/**
 * This class can not create any objects. It is made to be the super class of movie and audio
 * players.
 */
public abstract class Product implements Item {
  private String name;
  private String manufacturer;
  private int id;
  private ItemType type;

  public ItemType getType() {
    return type;
  }

  public void setType(ItemType type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * * This creates the audio player objects.
   * @param name this is the name of the player object.
   * @param manufacturer this is the name of the manufacturer of the object.
   * @param type this is the type of the product.
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }
}
