package task1;

import task2.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Market {
    private String name;
    private List<Product> products = new ArrayList<>();
    private Storage storage;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void addProduct(String productName, double cost, int amount){
        products.add(new Product(productName, cost, amount));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Market(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
    public Market(String name) {
        this.name = name;
        storage = new Storage();
    }

    public void print() {
        System.out.println();
        System.out.println(name);
        for (Product obj: products) {
            obj.print();
        }
    }

    public void moveToStorage(String productName, int amount){
        if(amount < 0){
            System.out.println("Out of amount");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)
                && products.get(i).getAmount() >= amount){
                storage.addProduct(products.get(i).getProductName(), products.get(i).getCost(), amount);
                products.get(i).setAmount(products.get(i).getAmount() - amount);
                return;
            }
        }
    }

    public double averange(){
        System.out.println("Averange cost is:");
        return products.stream()
                .mapToDouble((e1) -> e1.getAmount()*e1.getCost())
                .average()
                .getAsDouble();
    }

}
