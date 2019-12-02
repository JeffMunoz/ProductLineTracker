package productline;

/**
 * This class extends the abstract class of product. It creates the widget objects through the use
 * of one constructor, which takes in 4 arguments and calls the super constructor.
 *
 * @author Jeffry Munoz
 */
class Widget extends Product {
  public Widget(String name, String manufacturer, ItemType type, int id) {
    super(name, manufacturer, type, id);
  }
}
