package productline;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduct;

  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduct) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduct = dateProduct;
  }

  public ProductionRecord(int productId) {
    productionNumber = 0;
    this.productId = productId;
    serialNumber = "0";
    dateProduct = new Date();
  }

  public ProductionRecord(Product newProduct, int countNumber){
    serialNumber = newProduct.getManufacturer().substring(0,3) + newProduct.getType() + String.format("00000");
  }

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
