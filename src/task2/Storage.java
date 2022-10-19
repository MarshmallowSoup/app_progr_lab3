package task2;

import task1.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Storage {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Storage() {

    }

    public Storage(List<Product> products) {

        for (int i = 0; i < products.size(); i++) {
            try {
                validate(products.get(i));
                this.products.add(products.get(i));
            } catch (CheckedException e) {
                e.invoke();
                this.products.add(new Product(products.get(i).getProductName(), products.get(i).getCost(), 0));
            }
        }
    }

    private void validate(Product product) throws CheckedException {
        if (product.getAmount() < 0 || product == null) {
            throw new CheckedException(product.getProductName() + " is out of amount");
        }
    }

    public void print(){
        System.out.println();
        for (Product obj: products) {
            obj.print();
        }
    }

    public void addProduct(String productName, double cost, int amount){
        try {
            validate(new Product(productName, cost, amount));
            products.add(new Product(productName, cost, amount));
        }catch (CheckedException e){
            e.invoke();
            this.products.add(new Product(productName, cost, 0));
        }
    }

    public void sortByName(){
        products = products.stream()
                .sorted(Comparator.comparing(Product::getProductName))
                //.sorted((e1, e2) -> e1.getProductName().compareTo(e2.getProductName()))
                .collect(Collectors.toList());
    }

    public void sortByAmount(){
        products = products.stream()
                .sorted(Comparator.comparing(Product::getAmount))
                .collect(Collectors.toList());

    }

    public void filterByAmount(int amount){
        products.stream()
                .filter(e -> e.getAmount() > amount)
                .forEach(Product::print);
    }

}
