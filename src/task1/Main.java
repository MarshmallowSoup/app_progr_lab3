package task1;

public class Main {
    public static void main(String[] args) {
        Market market = new Market("Market1");
        market.addProduct("Bread", 20.50, 40);
        market.addProduct("Cola", 40, 20);
        market.addProduct("Rice", 70, 20);
        market.addProduct("BubbleGum", 10, 10);
        market.addProduct("Milk", 40.30, 7);

        market.print();

        Bill consumer1 = new Bill("Taras");
        consumer1.addProduct("Bread", 2, market);
        consumer1.addProduct("BubbleGum", 2, market);
        consumer1.addProduct("Meat", 4, market);

        Bill consumer2 = new Bill("Johny");
        consumer2.addProduct("Bread", 2, market);
        consumer2.addProduct("Milk", 2, market);


        consumer1.print();
        consumer2.print();


        market.moveToStorage("Cola", -20);

        market.print();
    }
}
