package Chapter04.Item20;

public abstract class AbstractClass {

    // 템플릿 메서드
    public final void templateMethod() {
        // 공통 로직
        commonMethod();

        // 하위 클래스에서 구현해야 하는 부분
        specificMethod();

        // 다른 하위 클래스에서 구현해야 하는 부분
        anotherSpecificMethod();
    }

    // 공통 로직
    private void commonMethod() {
        // 공통 로직 구현
        System.out.println("Common method implementation");
    }

    // 하위 클래스에서 구현해야 하는 추상 메서드
    protected abstract void specificMethod();

    // 다른 하위 클래스에서 구현해야 하는 메서드
    protected void anotherSpecificMethod() {
        // 다른 하위 클래스에서 구현해야 하는 부분
    }
}
