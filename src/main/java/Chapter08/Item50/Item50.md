# 적시에 방어적 복사본을 만들라

클라이언트로 반환하는 구성요소가 가변이라면 그 요소는 반드시 방어적으로 복사해야 한다.

단, 방어적 복사를 생략하는 경우는 그 비용이 너무 크거나 또는 요소를 잘못 수정할 일이 없다고 신뢰하는 경우이다.
