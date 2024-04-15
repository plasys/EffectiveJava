# ordinal 메서드 대신 인스턴스 필드를 사용하라

열거 타입에는 해당 상수가 그 열거타입에서 몇 번째 위치인지 반환하는 ordinal이라는 메서드를 제공한다.

근데 이 메서드를 이용하여 정수값을 활용하려다가 열거 타입 선언 순서가 변경되는 경우 혼란이 발생할 수 있다.

그래서 정수값 활용이 필요하다면 따로 인스턴스 필드로 저장하는 것이 좋다.
