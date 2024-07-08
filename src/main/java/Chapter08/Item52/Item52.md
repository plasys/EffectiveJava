# 다중정의(Overloading, 오버로딩)는 신중히 사용하라

다중정의는 어느 메서드를 호출할지 컴파일 타임에 정해진다.(정적)

그러므로 다중정의에 의해 의도하지 않는 동작이 발생하지 않으려면 

1. 매개변수가 같은 다중정의는 만들지 않는게 좋다.
2. 다중정의 하는 대신 메서드 이름을 다르게 지어주는 방법도 있다.