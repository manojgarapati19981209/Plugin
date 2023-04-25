package bankapp;
import java.util.ArrayList;
import java.util.Scanner;
class Account {
    private int accountId;
    private String customerName;
    private String address;
    private double balance;
    public Account(int accountId, String customerName, String address, double balance) {
        this.accountId = accountId;
        this.customerName = customerName;
        this.address = address;
        this.balance = balance;
    }
    public int getAccountId() {
        return accountId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAddress() {
        return address;
    }
    public double getBalance() {
        return balance;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void updateBalance(double amount) {
        balance += amount;
    }
    public void displayAccountSummary() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Balance: $" + balance);
    }
}
public class BankingApplication {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BankingApplication bankingApp = new BankingApplication();
        bankingApp.run();
    }
    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    addNewAccount();
                    break;
                case 2:
                    changeAddress();
                    break;
                case 3:
                    checkAccountBalance();
                    break;
                case 4:
                    updateAccountBalance();
                    break;
                case 5:
                    displayAccountSummary();
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }
    public void displayMenu() {
        System.out.println("Banking Application Menu:");
        System.out.println("1. Add New Account");
        System.out.println("2. Change Address of the Customer");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Update Account Balance");
        System.out.println("5. Summary of All Accounts");
        System.out.println("6. Quit");
    }
    public void addNewAccount() {
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Initial Amount: $");
        double initialAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        int accountId = accounts.size() + 1;
        Account account = new Account(accountId, customerName, "", initialAmount);
        accounts.add(account);
        System.out.println("Account created successfully. Account ID: " + accountId);
    }
    public void changeAddress() {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Account account = getAccountById(accountId);
        if (account != null) {
            System.out.print("Enter New Address: ");
            String newAddress = scanner.nextLine();
            account.setAddress(newAddress);
            System.out.println("Address updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
    public void checkAccountBalance() {
        System.out        .print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Account account = getAccountById(accountId);
        if (account != null) {
            System.out.println("Account ID: " + account.getAccountId());
            System.out.println("Customer Name: " + account.getCustomerName());
            System.out.println("Address: " + account.getAddress());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    public void updateAccountBalance() {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        Account account = getAccountById(accountId);
        if (account != null) {
            System.out.print("Enter Amount to Update: $");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            account.updateBalance(amount);
            System.out.println("Account balance updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
    public void displayAccountSummary() {
        System.out.println("Summary of All Accounts:");
        for (Account account : accounts) {
            System.out.println("--------------------");
            account.displayAccountSummary();
        }
        System.out.println("--------------------");
    }
    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }
}