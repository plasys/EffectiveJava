# clone 재정의는 주의해서 진행하라

Cloneable은 복제해도 되는 클래스임을 명시하는 용도인 믹스인 인터페이스이다.

메서드가 하나도 없지만 Object의 protected 메서드인 clone 동작방식을 결정한다.

Cloneable을 구현한 클래스의 인스턴스에서 clone을 호출하면 그 객체의 필드를 하나하나 복사한 객체를 반환하며,

그렇지 않은 클래스의 인스턴스에서 호출하면 CloneNotSupportedException을 던진다.



clone 메서드의 일반규약은 다음과 같다.

어떤 객체 x에 대해 다음식은 참이다.
- x.clone() != x
- x.clone().getClass() == x.getClass()
- x.clone().equals(x) [이 식은 일반적으로 참이지만 필수는 아님]


clone 재정의 방법은 불변객체의 경우 Clone 인터페이스를 구현 후 clone() 메서드를 재정의 하는 것이다.(super.clone() 사용)


clone 메서드는 사실상 생성자와 같은 효과를 낸다.

즉, clone은 원본 객체에 아무런 해를 끼치지 않는 동시에 복제된 객체의 불변식을 보장해야 한다.

그런데 가변 참조 필드를 super.clone()으로 복제해버리면 주소를 복사하기 때문에, 

원본이나 복제본 중 하나를 수정하면 다른 하나도 수정되어 불변식을 해치게 된다.

그러므로 가변 참조 필드가 있으면 clone() 메서드에서 재귀적으로 가변 객체 참조 필드를 복사하면 된다.

그런데 가변 참조 필드의 접근제어자가 final 이라면 새로운 값을 참조할 수 없으므로 위의 방식을 적용할 수 없다.

그래서 복제할 수 있는 클래스를 만들기 위해 일부 필드에서 final 한정자를 제거해야 할 수도 있다.


### 요약
Cloneable을 구현하는 모든 클래스는 clone을 재정의해야 한다.

이 때 접근 제한자는 public으로, 반환 타입은 클래스 자신으로 변경한다.

이 메서드는 가장 먼저 super.clone을 호출한 후 필요한 필드를 전부 적절히 수정한다.

Cloneable을 이미 구현한 클래스를 확장한다면 어쩔 수 없이 clone을 잘 작동하도록 구현해야 하지만,

그렇지 않은 상황에서는 복사 생성자와 복사 팩터리라는 방식을 제공할 수 있다.

```java
public Yum(yum yum) {...};
```

```java
public static Yum newInstance(Yum yum) {...};
```