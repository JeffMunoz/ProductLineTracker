package productline;

/**
 * This Interface has the basic methods that involve the product information.
 *
 * @author Jeffry Munoz
 */
// Interfaces with only one method are called functional interface

interface Item {
  String getName();

  String getManufacturer();

  int getId();

  void setName(String name);

  void setManufacturer(String manufacturer);
}
