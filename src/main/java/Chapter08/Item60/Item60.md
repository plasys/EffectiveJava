# 정확한 답이 필요하다면 float와 double은 피하라

float와 double은 이진 부동소수점 연산에 쓰이며, 넓은 범위의 수를 빠르게 정밀한 근사치로 계산하도록 세심하게 설계되었다.

따라서 정확한 결과가 필요할 때는 사용하면 안 된다.

정확한 답이 필요한 계산에는 BigDecimal을 사용하거나, 성능이 중요하고 숫자가 너무 크지 않으면 int나 long을 사용하는것이 좋다.