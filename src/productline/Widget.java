package productline;

/**
 * This class extends the abstract class of product. It creates the widget objects through the use
 * of one constructor, which takes in 3 arguments and calls the super constructor.
 */

class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
