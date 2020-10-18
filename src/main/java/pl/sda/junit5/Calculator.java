package pl.sda.junit5;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("1 + 2 = " + calculator.add(1, 2));
        System.out.println("1 - 2 = " + calculator.subtract(1, 2));
    }

    public long add(long a, long b) {
        return a + b;
    }

    public long subtract(long a, long b) {
        return a - b;
    }

}
