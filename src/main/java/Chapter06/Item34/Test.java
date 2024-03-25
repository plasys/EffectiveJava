package Chapter06.Item34;

public class Test {
    public static void main(String[] args) {
        System.out.println(Operation.MINUS.calculate(1,2));

        System.out.println(Operation.PLUS.calculate(1,2));

        Operation[] a = Operation.values();

        System.out.println(a[0]);
    }
}
