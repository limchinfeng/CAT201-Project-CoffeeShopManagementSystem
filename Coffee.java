public class Coffee {

    private String coffee;
    private double price;

    //Default constructor
    public Coffee() {
        this.coffee=null;
        this.price=0.0;
    }

    //Constructor with arguments
    public Coffee(String coffee, double price) {
        this.coffee=coffee;
        this.price=price;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}