package task3;

import task1.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CheckList {
    public static List<Product> list = new ArrayList<>();

    public static void add(Product product) {
        list.add(product);
    }

    public static List<Product> getList() {
        return list;
    }

    public static void setList(List<Product> list) {
        CheckList.list = list;
    }

    public static void print() {

        for (Product product : list) {
            System.out.print("--->");
            product.print();
        }
    }

    public static void mode() {
        list.stream()
                .sorted(Comparator.comparing(e -> -e.getAmount()))
                .limit(1)
                .forEach(e -> {
                    System.out.println(e.getProductName());
                });
    }

    public static void max(List<Customer> lisCust, int day) {

        System.out.println("The biggest sum of day "+day +"   "+ lisCust.get(0).getChecks().get(0).productsToBuy.stream()
                .mapToDouble(e-> e.getAmount()*e.getCost())
                .max().getAsDouble());
    }
}
