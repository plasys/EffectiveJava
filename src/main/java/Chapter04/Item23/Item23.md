# 태그 달린 클래스보다는 클래스 계층구조를 활용하라

태그 달린 클래스(현재 표현하는 의미를 태그 값으로 알려주는 클래스)의 단점
- 쓸데없는 코드가 많다
- 가독성이 나쁘다
- 메모리도 많이 사용한다

태그 달린 클래스보다는 클래스 계층구조를 활용하는 것이 좋다.

클래스 계층구조로 만드는 방법은 


1. 공통 메서드를 루트(root)가 될 추상 클래스를 정의후 추상 메서드로 선언한다.
2. 공통 데이터도 루트 클래스로 올린다.
3. 루트 클래스를 확장한 구체 클래스를 의미별로 하나씩 정의하고 각자의 의미에 해당하는 데이터 필드를 넣는다
4. 구체 클래스에서 추상 메서드를 각자의 의미에 맞게 구현한다.


