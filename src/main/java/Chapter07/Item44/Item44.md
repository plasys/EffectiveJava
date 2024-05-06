# 표준 함수형 인터페이스를 사용하라

자바에는 여러가지 표준형 인터페이스가 존재한다.

가장 기본적인 함수형 인터페이스로는 다음과 같다.

1. UnaryOperator<T>
2. BinaryOperator<T>
3. Predicate<T>
4. Function<T,R>
5. Supplier<T>
6. Consumer<T>

여기에 기본 타입을 반환하는 변형도 존재한다.(But 여기에 박싱된 기본타입을 넣어 사용은 금지)

이러한 표준형 인터페이스를 잘 활용하되, 가끔은 직접 함수형 인터페이스를 만들어야 하는 경우도 있다.

직접 만들때는 @FunctionalInterface 애너테이션을 꼭 붙이는 것이 좋다.