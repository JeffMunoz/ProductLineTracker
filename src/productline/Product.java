package productline;

public abstract class Product implements Item{
  private String name;
  private String manufaturer;
  private String type;
  private int    id;

  public String getName(){
    return name;
  }
  public String getManu(){
    return manufaturer;
  }
  public int getId(){
    return id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setManu(String manufaturer){
    this.manufaturer = manufaturer;
  }
  public Product(String name, String manufaturer, String type){
    this.name = name;
    this.manufaturer = manufaturer;
    this.type = type;
  }
  public String toString(){
    return"Name: " + name +"\n"+
        "Manufacturer: " + manufaturer+"\n"+
        "Type: " + type;

  }


}
class Widget extends Product{
  public Widget(String name, String manufaturer, String type){
    super(name,manufaturer,type);
  }

}


