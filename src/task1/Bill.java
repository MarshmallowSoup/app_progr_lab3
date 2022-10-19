package task1;

import task2.CheckedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bill {
    private String consumerName;
    private List<Product> productsToBuy = new ArrayList<>();
    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public List<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(List<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }

    public Bill(String consumerName, List<Product> productsToBuy, int day) {
        this.consumerName = consumerName;
        this.productsToBuy = productsToBuy;
        this.day = day;
    }

    public Bill(String consumerName){
        this.consumerName = consumerName;
    }

    public Bill(String consumerName, int day){
        this.consumerName = consumerName;
        this.day = day;
    }

    public void addProductToBuy(String productName, int amount, Market market )throws CheckedException {
        for (int i = 0; i < market.getProducts().size(); i++) {
            if(market.getProducts().get(i).getProductName().equals(productName)
                    && market.getProducts().get(i).getAmount() >= amount){
                productsToBuy.add(new Product(market.getProducts().get(i).getProductName(), market.getProducts().get(i).getCost() , amount));
                market.getProducts().get(i).setAmount(market.getProducts().get(i).getAmount() - amount);
                return;
            }
        }
        throw new CheckedException("");
    }

    public void addProduct(String productName, int amount, Market market ){
        for (int i = 0; i < market.getProducts().size(); i++) {
            if(market.getProducts().get(i).getProductName().equals(productName)
                    && market.getProducts().get(i).getAmount() >= amount){
                productsToBuy.add(new Product(market.getProducts().get(i).getProductName(), market.getProducts().get(i).getCost() , amount));
                market.getProducts().get(i).setAmount(market.getProducts().get(i).getAmount() - amount);
                return;
            }
        }
        System.out.println("Out of amount");
    }

    public void print() {
        System.out.println();
        double cost = 0;
        //System.out.println(consumerName);
        for (Product obj: productsToBuy) {
            obj.print();
            cost+=obj.getCost()* obj.getAmount();
        }
        System.out.println("Cost: "+cost);
        System.out.println();
    }


    public double sum(){
        System.out.println("Today "+ consumerName+" spent:");
        return productsToBuy.stream()
                .mapToDouble(e -> e.getCost()*e.getAmount())
                .sum();
    }

    public void group(){
        System.out.println("        Group");
        Map<String, Double> map = productsToBuy.stream()
                .collect(Collectors.toMap((e) -> e.getProductName(), (e) -> e.getCost()*e.getAmount()));
        System.out.println(map);
    }

    public void mode(){
        System.out.println("        Mode");
        productsToBuy.stream()
                .sorted(Comparator.comparing(Product::getAmount))
                .limit(1)
                .forEach(e -> System.out.println(e.getProductName()));

    }

    public void max(){
        System.out.println("        Today biggest bill: "+
        productsToBuy.stream()
                .mapToDouble(e -> e.getCost()*e.getAmount())
                .sum());
    }
}
