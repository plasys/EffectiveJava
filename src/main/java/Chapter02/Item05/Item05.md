# 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

많은 클래스가 하나 이상의 자원에 의존한다.

특히 자원을 직접 명시하여 유연하지 않은 클래스가 되는 경우가 많은데,

사용하는 자원에 따라 동작이 달라지는 클래스에는 그런 정적 클래스나 싱글턴 방식이 적합하지 않다.

이러한 점을 보완하기 위해 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식을 사용하면 된다.

인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 것이다.

```java
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    
    public boolean isValid(String word) {
        //...
    }
    public List<String> suggestions(String typo) {
        //...
    } 
}
```

이 의존 객체 주입 패턴은 자원이 몇개든 상관없이 잘 작동하며, 불변을 보장할 수도 있다.

이 패턴의 쓸만한 변형으로 생성자에 자원 팩토리를 넘겨주는 방식이 있다.

Supplier<T> 인터페이스를 넘겨주는 적절한 예시를 살펴보자.

```java
Mosaic create(Supplier<? extends Tile> tileFactory) {
   //...
}
    
```

이 방식에서 클라이언트는 자신이 명시한 타입의 하위 타입이라면 무엇이든 생성할 수 있는 팩토리를 넘길 수 있다.


# 핵심 정리

클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면

싱글턴과 정적 유틸리티 클래스는 사용하지 않는 것이 좋다.

이 자원들을 클래스가 직접 만들게 해서도 안 된다. 

대신 필요한 자원을(혹은 그 자원을 만들어주는 팩토리를) 생성자에(혹은 정적 팩토리나 빌더에) 넘겨주자.

의존 객체 주입이라 하는 이 기법은 클래스의 유연성, 재사용성, 테스트 용이성을 기막히게 개선해준다.
