package task3;

import task1.Market;
import task1.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Customer {
    private String name;
    private List<Check> checks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addList(List<Product> prod, Market market, int date) {
        int newAm;
        Check check = new Check(date);
        for (int i = 0; i < prod.size(); i++) {
            check.addProduct(prod.get(i).getProductName(), prod.get(i).getAmount(), market);
        }
        checks.add(check);
    }

    public void print() {
        System.out.println("        " + name);
        System.out.println(">=======================");
        for (Check check : checks) {
            check.print();
        }
        System.out.println("<=======================");
    }

    public void searchByDay(int day) {
        double cost = 0;
        System.out.println(" Search by day " + name + "  day: " + day);
        for (int i = 0; i < checks.size(); i++) {
            if (checks.get(i).getDate() <= day) {
                cost += checks.get(i).searchByDay();
            }
        }
        System.out.println("Cost: " + cost);
    }

    public void printByAmount() {
        System.out.println("    All products of " + name + ":");
        for (Check obj : checks) {
            obj.printByAmount();
        }
    }

    public void mode() {

        checks.stream().forEach((e) -> {
                System.out.println(e.mode());
        });
        //.collect(Collectors.toList((e) -> 1))
//                .collect(Collectors.toMap(
//                        (e) -> {
//                    //return e.getProductsToBuy().stream().collect(Collectors.toList());
//
//                },
//                        (e)-> {
//                            return 1;
//                        }));

    }

}