# 타입 안전 이종 컨테이너를 고려하라

일반적인 제네릭에서는 타입 매개변수(T)의 수가 고정되어 있다.

하지만 여러 임의타입의 값을 저장하고 싶다면 키를 타입 매개변수로 하는 타입 안전 이종 컨테이너 패턴을 사용하면 된다.

Class를 키로 사용하면(Class<?>) 그 타입에 매칭되는 여러 타입의 값을 저장할 수 있다.