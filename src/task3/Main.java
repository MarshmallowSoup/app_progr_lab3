package task3;

import task1.Market;
import task1.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market("ATB");
        market.addProduct("Bread", 20.50, 40);
        market.addProduct("Cola", 40, 20);
        market.addProduct("Rice", 70, 20);
        market.addProduct("BubbleGum", 10, 10);
        market.addProduct("Milk", 40.30, 7);

        market.moveToStorage("Bread", 12);
        market.moveToStorage("Cola",3);
        market.moveToStorage("Rice", 15);
        market.moveToStorage("BubbleGum", 6);
        market.moveToStorage("Milk", 1);



        market.print();



        List<Product> b1= new ArrayList<>();
        b1.add(new Product("Bread", 0, 2));
        b1.add(new Product("Cola", 0, 5));

        List<Product> b2= new ArrayList<>();
        b2.add(new Product("BubbleGum", 0, 1));

        Customer customer1 = new Customer("Anna");
        customer1.addList(b1, market, 1);
        customer1.addList(b2, market, 2);


        List<Product> b3= new ArrayList<>();
        b3.add(new Product("Rice", 0, 2));

        List<Product> b4= new ArrayList<>();
        b4.add(new Product("Milk", 0, 2));

        Customer customer2 = new Customer("Den");
        customer2.addList(b3, market, 1);
        customer2.addList(b4, market, 2);

        List<Customer> l_cust = new ArrayList<>();
        l_cust.add(customer1);
        l_cust.add(customer2);


        customer1.print();
        customer2.print();

        market.print();


        market.getStorage().print();

        System.out.println( "         Filter storage");
        market.getStorage().filterByAmount(3);


        System.out.println( "         Sort storage");
        market.getStorage().sortByName();

        market.getStorage().print();

        System.out.println(market.averange());

        customer1.searchByDay(1);

        customer1.printByAmount();

        //customer1.mode();

        CheckList.print();
        CheckList.mode();
        CheckList.max(l_cust, 1);
//
////        System.out.println(bill.sum());
////
////        bill.group();
////
////        bill.mode();
////
////        bill.max();
    }
}
