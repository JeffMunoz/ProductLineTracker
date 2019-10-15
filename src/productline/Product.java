package productline;
// Author: Jeff Munoz
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

  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }
}

class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
