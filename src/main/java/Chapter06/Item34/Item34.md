# int 상수 대신 열거 타입을 사용하라

정수, 문자열 열거 패턴은 타입 안전성을 보장할 수 없으며 표현력도 좋지 않다.

열거 타입(enum type)은 이런 단점을 없애고 여러 장점을 가져다준다.

자바의 열거 타입은 완전한 형태의 클래스이며 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개하므로, 인스턴스가 딱 하나만 존재한다.

열거 타입을 언제 사용해야 하는가?

1. 필요한 원소를 컴파일 타임에 다 알 수 있는 상수 집합인 경우(ex. 행성, 요일, 카드게임 등등)
2. 이 외에도 허용하는 원소의 값 모두를 컴파일 타임에 이미 알고 있는 경우

