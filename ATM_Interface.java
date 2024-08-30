import java.util.Scanner;

class BankAccount {
    private double balance;
    
    public BankAccount(double intialBalance) {
        this.balance = intialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.print("withdraw of S" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    
    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.println("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Existing ATM, Thank you!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter initial account balance: $");
        double intialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(intialBalance);
        
        ATM atm = new ATM(bankAccount);
        
        while (true) {
            atm.displayMenu();
            System.out.println("Select an option: ");
            int choice = scanner.nextInt();
            
            atm.performTransaction(choice, scanner);
        }
    }
}