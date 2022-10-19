package task1;

public class Product {
    private String productName;
    private double cost;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product(String productName, double cost, int amount) {
        this.productName = productName;
        this.cost = cost;
        this.amount = amount;
    }

    public void print(){
        System.out.println(productName+" "+ cost +" "+ amount);
    }

    public int compair(Product p1){
        return p1.getAmount() > this.getAmount()? this.getAmount(): p1.getAmount();
    }
}
