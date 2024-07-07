package domain.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final int agency = 123;
    private int number;
    private static int numberIncrement = 0;
    private double balance;
    private Customer owner;
    private List<String> statement = new ArrayList<>();
    final private String ansiGreen = "\u001B[32m";
    final private String ansiRed = "\u001B[31m";
    final private String ansiReset = "\u001B[0m";

    Account(Customer customer) {
        this.owner = customer;
        this.balance = 0;
        this.number = (numberIncrement += 1);
    }

    public void deposit(double value) {
        this.balance += value;
        this.statement.add(String.format("%s+ %.2f%s", ansiGreen, value, ansiReset));
    }

    public void withDraw(double value) {
        this.balance -= value;
        this.statement.add(String.format("%s- %.2f%s", ansiRed, value, ansiReset));
    }

    public double getBalance() {
        return this.balance;
    }

    public void transfer(double value, Account destinationAccount) {
        this.withDraw(value);
        destinationAccount.deposit(value);
    }

    public void printStatement() {
        if (this.statement == null || this.statement.isEmpty()) {
            System.out.println("There is no operations.");
        } else {
            System.out.println("Statement:");
            this.statement.forEach(System.out::println);
            System.out.printf("Actual balance = %.2f%n\n", this.getBalance());
        }
    }
}