public class Bank {

    private int numberOfTotalAccounts = 0;

    private BankAccount[] accountsArray = new BankAccount[2];





    public void registerBankAccount(BankAccount account){

        if (numberOfTotalAccounts + 1 > accountsArray.length) {
            dubleazaArray();
        }
        accountsArray[numberOfTotalAccounts] = account;
        numberOfTotalAccounts++;
    }

    public void deleteBankAccount(BankAccount account) {

        int i = getIndexAccount(account);

        if (i == -1) {
            System.out.println("nu-i");
            return;
        }

        for (int j = i; j < numberOfTotalAccounts-1 ; j++) {
            accountsArray[j] = accountsArray[j+1];
        }
        accountsArray[numberOfTotalAccounts-1] = null;
        numberOfTotalAccounts--;
    }

    public int getNumberOfTotalAccounts(){
        return numberOfTotalAccounts;

    }

    private void dubleazaArray() {
        BankAccount[] nouArray = new BankAccount[accountsArray.length * 2];

        for (int i = 0; i < accountsArray.length; i++) {
            nouArray[i] = accountsArray[i];
        }
        accountsArray = nouArray;

    }
    public int getIndexAccount(BankAccount account) {

        int start = 0, end = accountsArray.length - 1, middle = accountsArray.length / 2;

        while (start < end) {
            if (accountsArray[middle].getId() == account.getId()) {
                return middle;
            } else if (account.getId() < accountsArray[middle].getId()) {
                end = middle - 1;
                middle = (end + start) / 2;
            } else {
                start = middle + 1;
                middle = (end + start) / 2;
            }
        }
        return -1;



//        for (int i = 0; i < numberOfTotalAccounts; i++) {
//            if (account.getId() == accountsArray[i].getId()) {
//                return i;
//            }
//        }
//
//        return -1;
    }

    public boolean verifyCreditCard(String creditCardNumber){

        char number[] =creditCardNumber.toCharArray();
        int i;

        //length check
        if(number.length < 13 || number.length > 16){
            return false;
        }

        //CharArray to int array
        int nr[] = new int[number.length];
        for (i = 0; i <number.length ; i++) {
            nr[i] = (int)number[i] - 48;
        }

        //card company check
        if(!vendorCheck(nr[0], nr[1])) {
            return false;
        }

        // number check
        int evenSum = 0;
        int oddSum = 0;

        //evenSum
        for (i = nr.length-2; i >=0 ; i-=2) {
            evenSum+=numberdoubleinator(nr[i]);
        }

        //oddSum
        for (i = nr.length-1; i >=0 ; i-=2) {
            oddSum+=nr[i];
        }

        int checkSum = evenSum + oddSum;
        if(checkSum%10 != 0){
            return false;
        }

        //for (int i = 0; i <number.length ; i++) {
         //   System.out.print((int)number[i]);
    return true;
    }


    public boolean vendorCheck(int firstDigit, int secondDigit){
        switch (firstDigit){
            case 3:{
                if (secondDigit != 7){
                    return false;
                }
            }
            case 4:
            case 5:
            case 6:{
                return true;
            }
            default:{
                return false;
            }
        }
    }

    public int numberdoubleinator(int number){
        int doubeled = number*2;
        if(doubeled<10){
            return doubeled;
        }else{
            return doubeled%10 + doubeled/10;
        }
    }
}
