public enum Currency {

    RON(0.2378), USD(1), YEN(0.00925), EUR(1.1257);

    private double relativeValue = 1;

    private Currency(double relativeValue){
        this.relativeValue = relativeValue;
    }

    public double getRelativeValue() {

        return relativeValue;
    }

    public String printCurrency(){
        if(relativeValue == RON.relativeValue){
            return "RON";
        }
        if(relativeValue == YEN.relativeValue){
            return "YEN";
        }
        if(relativeValue == EUR.relativeValue){
            return "EUR";
        }
            return "USD";
    }


}
