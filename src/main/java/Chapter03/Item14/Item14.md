# Comparable을 구현할지 고려하라

Comparable 인터페이스에는 유일하게 compareTo 메서드가 존재한다.

Comparable을 구현했다는 것은 그 클래스의 인스턴스들에는 자연적인 순서가 있음을 뜻한다.

순서가 명확한 값 클래스를 작성한다면 반드시 Comaparable 인터페이스를 구현하자.


compareTo 메서드의 일반 규약은 equals의 규약과 비슷하다.

- 이 객체와 주어진 객체의 순서를 비교한다. 이 객체가 주어진 객체보다 작으면 음의 정수를, 같으면 0을, 크면 양의 정수를 반환한다.
  이 객체와 비교할 수 없는 타입의 객체가 주어지면 ClassCastException을 던진다.

(이하 책 참조...)


구현 방법은 박싱된 기본 타입 클래스들에 새로 추가된 정적 메서드인 compare을 이용하면 된다.

클래스에 핵심 필드가 여러개라면 가장 핵심적인 필드부터 비교해나가면 된다.

비교 결과가 0이 아니라면, 즉 순서가 결정되면 그 결과를 바로 반환하도록 한다.

```java
public int compareTo(PhoneNumber pn) {
    int result = Short.compare(areCode, pn.areCode); // 가장 중요한 필드
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix); // 두 번째로 중요한 필드
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum); // 세 번째로 중요한 필드
        } 
    }  
```

또는 자바의 정적 임포토 기능을 이용하면 정적 비교자 생성 메서드들을 그 이름만으로 사용할 수 있어 코드가 훨씬 깔끔해진다.

```java
private static final Comparator<PhoneNumber> COMPARATOR =
    comparingInt((PhoneNumber pn) -> pn.areaCode)
        .thenComparingInt(pn -> pn.prefix)
        .thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn) {
    return COMPARATOR.compare(this, pn);
}
```

정리하면, 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현하여 컬렉션과 어우러지도록 해야 한다.

compareTo 메서드에서 필드 값을 비교할 때 < > 연산자 대신 정적 compare 메서드나 Comparator 인터페이스가 제공하는 비교자 생성 메서드를 사용하자.