# 공유 중인 가변 데이터는 동기화해 사용하라

동기화는 일관성을 유지시켜 주며, 동기화된 메서드나 블록에 들어간 스레드가 같은 락의 보호하에 수행된 모든 이전 수정의 최종 결과를 보게 해준다.

즉, 동기화를 하지 않으면 한 스레드가 수행한 변경을 다른 스레드가 보지 못할 수도 있다.

그러므로 여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화 해야 한다.
(애초에 가변 데이터를 공유하지 않는 편이 좋다)