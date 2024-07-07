import domain.model.Account;
import domain.model.Bank;
import domain.model.Customer;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Test bank");
        Customer customer = bank.createCustomer("John Doe");
        Account currentAccount = bank.createCurrentAccount(customer);
        Account savingsAccount = bank.createSavingsAccount(customer);

        currentAccount.deposit(1000);
        currentAccount.withDraw(100);
        currentAccount.transfer(500, savingsAccount);
        System.out.printf("%.2f%n\n", currentAccount.getBalance());
        currentAccount.printStatement();

        savingsAccount.deposit(100);
        savingsAccount.withDraw(50);
        System.out.printf("%.2f%n\n", savingsAccount.getBalance());
        savingsAccount.printStatement();
    }
}