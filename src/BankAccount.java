import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {

    private String username;
    private int balance;
    private LocalDateTime dateOpen;
    private boolean banned;
    private String number;

    public BankAccount(String username) {
        this.username = username;
        this.balance = 0;
        this.banned = false;
        this.dateOpen = LocalDateTime.now();
        this.number = generateAccountNumber();
    }

    public boolean deposit(int amount) {
        if (banned || amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (banned || amount <= 0) {
            return false;
        }
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount == null) {
            return false;
        }
        if (banned || otherAccount.banned || amount <= 0) {
            return false;
        }
        if (balance < amount) {
            return false;
        }

        balance -= amount;
        otherAccount.balance += amount;
        return true;
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Номер счета: " + number +
                "\nИмя владельца: " + username +
                "\nБаланс: " + balance +
                "\nДата открытия: " + dateOpen +
                "\nСтатус счета: " + (banned ? "Заблокирован" : "Активен");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
