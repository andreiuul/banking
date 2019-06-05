public class BankAccount {

    private static int counter = 0;

    private final int id;

    private String ownerName;

    private Currency currency;

    private double sold;


    public BankAccount(Currency currency, String ownerName) {
        id = counter;
        counter++;
        this.currency = currency;
        this.ownerName = ownerName;
    }


    public void withdrawMoney(double sum) {
        if (sum > sold) {
            System.out.println("credit insuficient");
            return;
        }
        if (sum < 0) {
            System.out.println("valoare incorecta");
            return;
        }
        sold -= sum;

    }

    public void withdrawMoney(double sum, Currency currency) {
        double relativeSum = sum * currency.getRelativeValue() / this.currency.getRelativeValue();//convert withdrawal to local currency
        if (relativeSum > sold) {
            System.out.println("credit insuficient");
            return;
        }
        if (sum < 0) {
            System.out.println("valoare incorecta");
            return;
        }
        sold -= relativeSum;

    }

    public void depositMoney(double sum) {
        if (sum < 0) {
            System.out.println("valoare incorecta");
            return;
        }
        sold += sum;

    }

    public void depositMoney(double sum, Currency currency) {
        if (sum < 0) {
            System.out.println("valoare incorecta");
            return;
        }

        sold += sum * currency.getRelativeValue() / this.currency.getRelativeValue();//convert withdrawal to local currency
    }

    public double getSold() {
        return sold;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getId() {
        return id;
    }
}





