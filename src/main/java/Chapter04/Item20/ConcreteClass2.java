package Chapter04.Item20;

public class ConcreteClass2 extends AbstractClass {

    @Override
    protected void specificMethod() {
        // ConcreteClass2에 특화된 로직 구현
        System.out.println("Specific method for ConcreteClass2");
    }

    @Override
    protected void anotherSpecificMethod() {
        // ConcreteClass2에 특화된 로직 구현
        System.out.println("Another specific method for ConcreteClass2");
    }
}
