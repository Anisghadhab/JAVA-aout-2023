import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;
    private long accountNumber = 100_000_000;

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numberOfAccounts++;
        totalAmount += checkingBalance + savingsBalance;
        System.out.println(generateBankNumber());
    }
    public String generateBankNumber() {
        Random random = new Random();
        accountNumber = random.nextInt(900_000_000) + 100_000_000;
        return String.format("%010d", accountNumber);
    }
    public static int bankCount() {
        return numberOfAccounts;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setCheckingBalance(double amount) {
        this.checkingBalance += amount;
    }

    public void setSavingsBalance(double amount) {
        this.savingsBalance += amount;
    }

    public void setWithdraw(double amount) {
        if (this.checkingBalance < amount) {
            System.out.println("not enough solde");
        }
        else {
            this.checkingBalance -= amount;
        }
    }

}
