public class BankTest {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();

        System.out.println(BankAccount.bankCount());
        System.out.println(BankAccount.getTotalAmount());
        System.out.println(bankAccount1.getCheckingBalance());
        System.out.println(bankAccount1.getSavingsBalance());
        bankAccount1.setCheckingBalance(100);
        bankAccount1.setSavingsBalance(55);

        System.out.println(bankAccount1.getCheckingBalance());
        System.out.println(bankAccount1.getSavingsBalance());
        bankAccount1.setWithdraw(110);
        System.out.println(bankAccount1.getCheckingBalance());
        System.out.println(bankAccount1.getSavingsBalance());
    }
}
