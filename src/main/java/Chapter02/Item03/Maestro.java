package Chapter02.Item03;

// 원소가 하나인 열거 타입을 선언
public enum Maestro {
    Jhin(5);

    private final int cost;

    Maestro(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
