# 표준 예외를 사용하라

상황에 부합하는 표준 예외를 사용하자. 주로 사용되는 예외는 다음과 같다.

- IllegalArguementException : 허용하지 않는 값이 인수로 건네졌을 때
- IllegalStateException : 객체가 메서드를 수행하기에 적절하지 않은 상태일 때
- NullPointerExcepion : null을 허용하지 않는 메서드에 null을 건넸을 때
- IndexOutOfBoundsException : 인덱스가 범위를 넘어섰을 때
- ConcurrentModificationException : 허용하지 않는 동시 수정이 발견됐을 때
- UnsupportedOperationException : 호출한 메서드를 지원하지 않을 때