package productline;

import java.util.Date;

/**
 * This class is used to record the production of all objects.
 *
 * @author Jeffry Munoz
 */
public class ProductionRecord {
  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduct;

  /**
   * * This creates the production record objects.
   *
   * @param productionNumber this is the number of items made.
   * @param productId this is the int ID of the products.
   * @param serialNumber this is a unique string for all objects.
   * @param dateProduct this is the date when the product was made.
   */
  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduct) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduct = dateProduct;
  }

  /**
   * * This creates the production record objects. It is an overloaded constructor.
   *
   * @param productId this is the int ID of the products.
   */
  public ProductionRecord(int productId) {
    productionNumber = 0;
    this.productId = productId;
    serialNumber = "0";
    dateProduct = new Date();
  }

  /**
   * * This creates the production record objects. It is an overloaded constructor.
   *
   * @param newProduct this is the product object used to create the serial number.
   * @param countNumber this is the number of products of a certain type.
   */
  public ProductionRecord(Product newProduct, int countNumber) {
    serialNumber =
        newProduct.getManufacturer().substring(0, 3)
            + newProduct.getType().code
            + String.format("%05d", countNumber);
    dateProduct = new Date();
  }

  @Override
  public String toString() {
    return "Production Num: "
        + productionNumber
        + "Product ID: "
        + productId
        + "Serial Num: "
        + serialNumber
        + "Date: "
        + dateProduct;
  }

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getDateProduct() {
    return dateProduct;
  }

  public void setDateProduct(Date dateProduct) {
    this.dateProduct = dateProduct;
  }
}
