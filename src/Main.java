public class Main {

    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(Currency.USD, "NELU");
        BankAccount b2 = new BankAccount(Currency.USD, "GICA");
        BankAccount b3 = new BankAccount(Currency.EUR, "TICA");
        BankAccount b4 = new BankAccount(Currency.RON, "DOREL");

        b1.depositMoney(50);
        b2.depositMoney(20);
        b3.depositMoney(50, Currency.USD);
        b4.depositMoney(50, Currency.USD);

        Bank banca = new Bank();
        banca.registerBankAccount(b1);
        banca.registerBankAccount(b2);
        banca.registerBankAccount(b3);
        banca.registerBankAccount(b4);

        banca.deleteBankAccount(b3);

        System.out.println(b1.getSold());
        System.out.println(b2.getSold());
        System.out.println(b3.getSold());
        System.out.println(b4.getSold());

        b1.withdrawMoney(20);
        b3.withdrawMoney(20, Currency.USD);
        System.out.println(b1.getSold()+ b1.getCurrency().printCurrency());
        System.out.println(b3.getSold() + b3.getCurrency().printCurrency());

        if(banca.verifyCreditCard("4388576018402626")){ //numarul din exemplu; nu o sa fie bun
            System.out.println("e bun");
        }else{
            System.out.println("nu e bun");
        }


    }

}
