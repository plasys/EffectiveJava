# 로 타입(raw type)은 사용하지 말라

로 타입은 과거 자바 코드와의 호환성 때문에 제공되고 있다.

로 타입을 사용하면 제네릭의 타입 안정성과 표현력을 모두 잃게 된다.

실제 타입 매개변수가 무엇인지 신경쓰지 않고 싶을때는 물음표(와일드카드)를 사용하자.

```java
static int numElementsInCommon(Set<?> s1, Set<?> s2) {...}
```

이렇게 하면 타입 불변식을 훼손하지 못하게 막을 수 있다.

하지만 예외적으로 로 타입을 사용해야 하는 경우도 있다.

첫 번째로 class 리터럴에는 로 타입을 써야 한다.

ex) List.class, String[].class, int.class 는 허용, List<String>.class와 List<?>.class는 허용하지 않는다.

두 번째로는 instanceof 연산자와 관련이 있다.

런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는 비한정적 와일드카드 타입(<?>) 이외의 매개변수화 타입에는 적용할 수 없다.

제네릭 타입에 instanceof를 사용하는 올바른 예는 다음과 같다.

```java
if(o instanceof Set) {      // 로 타입
    Set<?> s = (Set<?>) o;  // 와일드카드 타입
}
```

