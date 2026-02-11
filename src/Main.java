public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Иван");
        BankAccount acc2 = new BankAccount("Петр");

        acc1.deposit(1000);
        acc1.transfer(acc2, 400);

        System.out.println(acc1);
        System.out.println();
        System.out.println(acc2);
    }
}
