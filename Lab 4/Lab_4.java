import java.util.ArrayList;
import java.util.Scanner;

public class Lab_4 {

    

    private static final double Withdrawmoney = 0;
    private String accountHolderName;
    private double accountBalance;
    private ArrayList<String> transactions;
    private int accountNumber;

    public Lab_4(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.transactions = new ArrayList<String>();
        this.transactions.add(String.format("Initial balance: $%.2f", accountBalance));
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            transactions.add(String.format("Deposit: $%.2f", amount));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            transactions.add(String.format("Withdrawal: $%.2f", amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void printTransactions() {
        System.out.println("Transaction history:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void printSummary() {
        System.out.println("Account summary:");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.printf("Account balance: $%.2f\n", accountBalance);
    }

    public double getAccountBalance() {
        return accountBalance;
    }

public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int accountNumber;
            String accountHolderName;
            double accountBalance;
            System.out.println("Enter account number:");
            accountNumber = input.nextInt();
            System.out.println("Enter account holder name:");
            input.nextLine();
            accountHolderName = input.nextLine();
            System.out.println("Enter account balance:");
            accountBalance = input.nextDouble();
            Lab_4 account = new Lab_4(accountNumber, accountHolderName, accountBalance);
            int choice;
            do {
                System.out.println("\nChoose an option:");
                System.out.println("1. Deposit money");
                System.out.println("2. Withdraw money");
                System.out.println("3. Print transactions");
                System.out.println("4. Print account summary");
                System.out.println("5. Exit");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter deposit amount:");
                        double depositAmount = input.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter withdrawal amount:");
                        account.withdraw(Withdrawmoney);
                    case 3:
                        account.printTransactions();
                    break;
                    case 4:
                        account.printSummary();
                        break;
                    case 5:
                         System.out.println("Exiting...");
                         break;
                default:
                    System.out.println("Invalid choice.");
            }
   } while (choice != 5);
        }
}

public Lab_4() {
            }}