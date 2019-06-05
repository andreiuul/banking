public enum Currency {

    RON(0.2378), USD(1), YEN(0.00925), EUR(1.1257);

    private double relativeValue = 1;

    private Currency(double relativeValue){
        this.relativeValue = relativeValue;
    }

    public double getRelativeValue() {
        return relativeValue;
    }
}
