# 가능한 한 실패 원자적으로 만들라

호출된 메서드가 실패하더라도 해당 객체는 메서드 호출 전 상태를 유지해야 한다.

메서드를 실패 원자적으로 만드는 방법
1. 불변 객체로 설계
2. 가변 객체의 경우는 매개변수의 유효성을 검사
3. 실패 가능성 있는 코드를 객체 상태 변경 코드보다 앞에 배치
4. 객체의 임시 복사본에서 작업을 수행한 다음, 작업이 성공적으로 완료되면 원래 객체와 교체
5. 실패를 가로채는 복구 코드를 작성하여 작업 전 상태로 되돌리기

객체의 상태를 메서드 호출 전과 똑같이 유지하지 못한다면 실패 시의 객체 상태를 API 설명에 명시해야 한다.
