# 스트림은 주의해서 사용하라

보통 스트림을 사용하는 경우는 다음과 같다.

- 원소들을 일관되게 변환
- 원소들을 필터링
- 원소들을 연산을 통해 결합
- 원소들을 컬렉션에 모으기

하지만 너무 과한 스트림의 사용은 가독성을 해치고 유지보수를 어렵게 한다.

굳이 스트림을 사용하지 않고도 기존의 반복문 등을 활용해 같은 기능을 구현할 수 있다.

그러므로 스트림을 적절하게 활용할 수 있는 곳에서 사용하자. 