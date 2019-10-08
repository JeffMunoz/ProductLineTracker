package productline;

public abstract class Product implements Item {
  private String name;
  private String manufacturer;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  private String type;
  private int id;

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

  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }
}

class Widget extends Product {
  public Widget(String name, String manufacturer, String type) {
    super(name, manufacturer, type);
  }
}
