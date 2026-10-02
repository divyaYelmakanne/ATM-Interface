import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    private static int balance = 50000;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney(scanner);
                    break;

                case 3:
                    withdrawMoney(scanner);
                    break;

                case 4:
                    transferMoney(scanner);
                    break;

                case 5:
                    viewTransactionHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Check Balance
    private static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Deposit Money
    private static void depositMoney(Scanner scanner) {

        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount > 0) {
            balance += amount;

            transactionHistory.add("Deposited: ₹" + amount);

            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw Money
    private static void withdrawMoney(Scanner scanner) {

        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            transactionHistory.add("Withdrawn: ₹" + amount);

            System.out.println("Withdrawn: ₹" + amount);

        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    // Transfer Money
    private static void transferMoney(Scanner scanner) {

        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            transactionHistory.add("Transferred: ₹" + amount);

            System.out.println("Transferred: ₹" + amount);

        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    // Transaction History
    private static void viewTransactionHistory() {

        System.out.println("Transaction History:");

        if (transactionHistory.isEmpty()) {

            System.out.println("No transactions yet.");

        } else {

            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
