package task2;

import task1.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> info = new ArrayList<>();
        info.add(new Product("Bread", 20, 4));
        info.add(new Product("Cola", 50.50, 20));
        info.add(new Product("BubbleGum", 10, -44));

        Storage storage = new Storage(info);
        storage.print();
    }
}
