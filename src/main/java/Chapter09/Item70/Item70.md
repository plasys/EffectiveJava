# 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라

호출하는 쪽에서 복구하리라 여겨지는 상황이라면 검사 예외(Checked Exception)를 사용하라.

프로그래밍 오류를 나타낼 때는 런타임 예외(Runtime Exception)를 사용하라.

검사 예외도 아니고 런타임 예외도 아닌 throwable은 정의하지 말자.

검사 예외라면 복구에 필요한 정보를 알려주는 메서드도 제공하자.