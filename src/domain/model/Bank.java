package domain.model;

public class Bank {
    private static final int id = 123;
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Customer createCustomer(String customerName) {
        return new Customer(customerName);
    }

    public Account createCurrentAccount(Customer customer) {
        return new CurrentAccount(customer);
    }

    public Account createSavingsAccount(Customer customer) {
        return new SavingsAccount(customer);
    }
}