# equals는 일반 규약을 지켜 재정의하라

Object에서 final이 아닌 메서드(equals, hashCode, toString, clone, finalize)는 모두 재정의(overriding)를 염두에 두고 설계된 것이라 재정의 시 지켜야 하는 일반 규약이 명확히 정의되어 있다.

그래서 Object를 상속하는 클래스, 즉 모든 클래스는 이 메서드들을 일반 규약에 맞게 재정의해야 한다.

메서드를 잘못 구현하면 대상 클래스가 이 규약을 준수한다고 가정하는 클래스(HashMap과 HashSet 등)를 오작동하게 만들 수 있다.


이러한 관점에서 equals를 재정의하지 않는 상황은 다음과 같다.

- 각 인스턴스가 본질적으로 고유할 때.

    값을 표현하는게 아닌 동작하는 개체를 표현하는 클래스가 여기 해당된다. ex)Thread
- 인스턴스의 논리적 동치성을 검사할 일이 없을 때.
- 상위 클래스에서 재정의한 equals가 하위 클래스에도 잘 적용될 때.

    대부분의 Set 구현체는 AbstractSet이 구현한 equals를 상속받아 쓰고, List 구현체들은 AbstractList로부터, Map 구현체들은 AbstractMap으로부터 상속받아 그대로 쓴다.
- 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없을 때.


****equals는 논리적 동치성을 확인해야 하는데, 상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의되지 않았을 때 재정의해야 한다.****

주로 값 클래스들이 여기 해당한다. 값 클래스란 Integer와 String처럼 값을 표현하는 클래스를 말한다.

equals 메서드를 재정의 할 때는 반드시 일반 규약을 따라야 한다.

- 반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
- 대칭성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.
- 추이성 : null이 아닌 모든 참조 값 x,y,z에 대해, x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true다.
- 일관성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
- null-아님 : null이 아닌 모든 참조 값 x에 대해 x.equals(null)은 false다.


이 규약들을 지키는 equals 메서드 구현 방법을 단계별로 살펴본다.
1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
3. 입력을 올바른 타입으로 형변환한다.
4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.

```java
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }
    
    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)  // 참조 비교
            return true;
        if (!(o instanceof PhoneNumber)) // 형변환, 타입 비교
            return false;
        PhoneNumber pn = (PhoneNumber) o; // 핵심 필드 비교
        return pn.lineNum == lineNum && pn.prefix = prefix && pn.areaCode = areaCode;
    }
}
```

이 외 주의사항으로는

* equals를 재정의할 땐 hashCode도 반드시 재정의하자(아이템 11에서 다룸)
* 복잡하게 생각하지 말고 필드들의 동치성만 검사해도 equals 규약을 어렵지 않게 지킬 수 있다.
* Object 외의 타입을 매개변수로 받는 equals 메서드는 선언하지 말자.
```java
public boolean equals(MyClass o) {
    // ...
}
```
이렇게 작성하게 되면 매개변수 타입이 달라 오버라이딩이 아닌 오버로딩이 되어버린다.
