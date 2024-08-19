# 네이티브 메서드는 신중히 사용하라

네이티브 메서드란 C나 C++ 같은 네이티브 프로그래밍 언어로 작성한 메서드이다.

네이티브 메서드의 단점

- 언어가 안전하지 않으므로 메모리 훼손 오류가 발생할 수 있음
- 플랫폼을 많이 타서 이식성이 낮음
- 디버깅이 낮음
- 속도가 느림
- 비용이 추가됨
- 네이티브 메서드와 자바 코드 사이의 접착 코드가 필요하므로 더 많은 작업이 필요하며 가독성도 떨어짐


네이티브 코드는 최소한만 사용해야 하고 많은 테스트가 필요하다.