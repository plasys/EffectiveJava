# 인터페이스는 타입을 정의하는 용도로만 사용하라

인터페이스는 자신을 구현한 클래스의 인스턴스를 참조할 수 있는 타입 역할을 한다.

인터페이스는 오직 타입을 정의하는 용도로만 사용해야 한다.

안티 패턴의 한 가지 예시로는 상수 인터페이스가 있다.

```java
public interface PhysicalConstants {
    static final double A = 1;
    static final double B = 2;
    static final double C = 3;
}
```

상수 인터페이스의 구현은 내부 구현을 노출하는 행위이며, 클라이언트 코드가 내부 구현에 해당하는 이 상수들에 종속되게 한다.

상수를 공개할 목적이라면 다음과 같은 방법을 사용하면 된다.
1) 특정 클래스나 인터페이스 자체에 추가
2) 열거 타입으로 공개
3) 인스턴스화 할 수 없는 유틸리티 클래스에 담아 공개

