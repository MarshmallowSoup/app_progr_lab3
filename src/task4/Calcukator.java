package task4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calcukator {
    private double first;
    private double second;

    public Calcukator(double first, double second) {
        System.out.println("First = "+first);
        System.out.println("Second = "+second);
        this.first = first;
        this.second = second;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }


    public void makeCalc() {
        SumClass sumClass = new SumClass();
        MinusClass minusClass = new MinusClass();
        MultClass multClass = new MultClass();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {

        Future<Double> div = executorService.submit(() -> {
            System.out.println("4Del go");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}

            return first/second;
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        sumClass.start();
        minusClass.start();
        multClass.start();


            System.out.println("4Div = " + div.get());

        }catch (Exception e){}


        try {
            executorService.shutdown();
        }
        catch (Exception e){
            executorService.shutdown();
        }
        finally {
            executorService.shutdown();
        }
    }


    private class SumClass extends Thread {
        public void sum() {
            try {
                System.out.println("1Sum go");
                Thread.sleep(2000);
                System.out.println("1Sum = " + (first + second));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Sum interrupted");
            }
        }

        @Override
        public void run() {
            sum();
        }
    }

    private class MinusClass extends Thread {
        public void min() {
            try {
                System.out.println("2Min go");
                Thread.sleep(1000);
                System.out.println("2Min = " + (first - second));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Min interrupted");
            }
        }

        @Override
        public void run() {
            min();
        }
    }

    private class MultClass extends Thread {
        public void mult() {
            try {
                System.out.println("3Mult go");
                Thread.sleep(2000);
                System.out.println("3Mult = " + (first * second));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Mult interrupted");
            }
        }

        @Override
        public void run() {
            mult();
        }

    }
}
