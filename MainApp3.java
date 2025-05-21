class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + 
                         ", Holder: " + accountHolder + 
                         ", Balance: " + balance);
    }
}

class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[5];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < 5) {
            accounts[count] = account;
            count++;
            System.out.println("Account added successfully!");
        } else {
            System.out.println("Bank cannot have more than 5 accounts!");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        boolean accountFound = false;
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                accountFound = true;
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful. New balance: " + accounts[i].getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            }
        }
        if (!accountFound) {
            System.out.println("Account not found!");
        }
    }

    public void displayAllAccounts() {
        System.out.println("\nAll Bank Accounts:");
        if (count == 0) {
            System.out.println("No accounts in the bank.");
            return;
        }
        for (int i = 0; i < count; i++) {
            accounts[i].displayDetails();
        }
    }
}

public class MainApp3 {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdrawFromAccount(1001, 6000.0);  
        bank.withdrawFromAccount(1002, 1000.0);  

        bank.displayAllAccounts();
    }
}
