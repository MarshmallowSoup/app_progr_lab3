package task3;

import task1.Market;
import task1.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Check {
    List<Product> productsToBuy = new ArrayList<>();
    int date;

    public List<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(List<Product> productsToBuy) {
        this.productsToBuy = productsToBuy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Check(int date) {

        this.date = date;
    }

    public Check(List<Product> productsToBuy, int date) {
        this.productsToBuy = productsToBuy;
        this.date = date;
    }

    public void addProduct(String productName, int amount, Market market) {
        for (int i = 0; i < market.getProducts().size(); i++) {
            if(market.getProducts().get(i).getProductName().equals(productName)
                    && market.getProducts().get(i).getAmount() >= amount){
                productsToBuy.add(new Product(market.getProducts().get(i).getProductName(), market.getProducts().get(i).getCost() , amount));
                CheckList.add(new Product(market.getProducts().get(i).getProductName(), market.getProducts().get(i).getCost() , amount));
                market.getProducts().get(i).setAmount(market.getProducts().get(i).getAmount() - amount);
                return;// market.getProducts().get(i).getAmount() - amount;
            }
        }
        System.out.println("Out of amount");
    }

    public void print(){
        double cost = 0;
        System.out.println("    Day"+ date);
        for (Product obj: productsToBuy) {
            obj.print();
            cost+=obj.getCost()* obj.getAmount();
        }
        System.out.println("Cost: "+cost);
        System.out.println();
    }

    public double searchByDay(){
        return productsToBuy.stream()
                .mapToDouble(e->e.getAmount()*e.getCost())
                .sum();
    }

    public void printByAmount(){
        productsToBuy.stream()
                .forEach(e-> System.out.println(e.getProductName()+" "+ e.getAmount()) );
    }

    public String mode(){
        List<Product> a  = productsToBuy.stream()
                .sorted(Comparator.comparing(e-> - e.getAmount()))
                .limit(1)
                .peek(e -> e.getProductName())
                .collect(Collectors.toList());
        System.out.println(a);
        return  a.get(0).getProductName();
    }

    public double sum(){
        return productsToBuy.stream()
                .mapToDouble(e -> e.getAmount()*e.getCost())
                .sum();
    }
}
