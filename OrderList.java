public class OrderList {

    private static int i=1;

    private static double total=0.0;
    private int index;
    private String coffee;
    private String size;
    private String type;
    private String add;
    private double price;


    //Default constructor
    public OrderList() {
        this.index=0;
        this.coffee=null;
        this.size=null;
        this.type=null;
        this.add=null;
        this.price=0.0;
    }

    //Constructor with arguments
    public OrderList(String coffee, String size, String type, String add, double price) {
        this.index=this.i;
        this.coffee=coffee;
        this.size=size;
        this.type=type;
        this.add=add;
        this.price=price;
        this.i++;
        this.total+=this.price;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String addon) {
        this.add = addon;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double price) {
        this.total -= price;
    }

}

