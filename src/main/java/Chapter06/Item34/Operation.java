package Chapter06.Item34;

public enum Operation {
    PLUS("+") {public double calculate(double x, double y) {return x + y;}},
    MINUS("-") {public double calculate(double x, double y) {return x - y;}};

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    abstract double calculate(double x, double y);

    public String getSymbol() {
        return symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }
}
