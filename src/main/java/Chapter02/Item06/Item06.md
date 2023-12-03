# 불필요한 객체 생성을 피하라

똑같은 기능의 객체를 불필요하게 매번 생성할 필요는 없다.

가능하다면 객체 하나를 재사용 하는 것이 더 효율적이다.

예를 들어 

```java
String s = new String("new");
```
위와 같은 코드는 매번 새로운 인스턴스를 생성하게 된다.


```java
String s = "new";
```

이 코드는 매번 새로운 인스턴스를 만들지 않고 하나의 인스턴스를 계속 사용한다.

생성자 대신 정적 팩토리 메서드를 사용하면 역시 객체를 매번 생성하지 않고 재사용할 수 있다.


특히 생성 비용이 큰 객체는 클래스 초기화 과정에서 직접 생성해두고 나중에 계속해서 재활용 하는 것이 좋다.


```java
static boolean isRomanNumeral(String s){
    return s.matches("^(?=.)M*(C[MD]|D?C{0,3}"
        +"(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
}
```
위와 같은 코드는 Pattern 인스턴스를 한번 쓰고 버려진다.

그러므로 불변인 Pattern 인스턴스를 직접 생성해두고 나중에 이 인스턴스를 필요할 때 호출해 재사용하는 것이 좋다.

```java
import java.util.regex.Pattern;

public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3}"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    
    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
```

불필요한 객체를 만들어내는 또 다른 예로 오토박싱을 들 수 있다.

오토박싱을 할 때 기본형 타입의 값을 새로운 박싱된 기본 타입 인스턴스를 생성해 담게 된다.

```java
private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
        sum += i;
    }
    return sum;
}
```

long 타입인 i가 더해질 때 Long 타입으로 바뀌면서 매번 새로운 인스턴스가 불필요하게 생성된다.

그러므로 의도치 않은 오토박싱은 사용하지 않는 것이 좋다.


하지만 이번 주제의 핵심은 객체 생성은 비싸니 피해야 한다가 아니라,

프로그램의 명확성, 간결성, 기능을 위해서라면 객체를 추가로 생성하고 불필요한 객체 생성을 하지 말자는 것이다.