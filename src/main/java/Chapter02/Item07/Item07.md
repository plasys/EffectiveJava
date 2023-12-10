# 다 쓴 객체 참조를 해제하라

```java
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    public Object pop() {
        if (size == 0) 
            return new EmptyStackException();
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) 
            elements = Arrays.copyOf(elements, (size * 2) + 1);
    }
}
```

위의 코드는 스택을 구현한 것이다.

코드에 별 문제가 없어보이지만, pop을 할 때 스택에서 꺼내진 객체를 가비지 컬렉터가 회수하지 않아 메모리 누수가 일어난다.

이 문제를 해결하려면 객체를 꺼낼 때 null 처리(참조 해제)를 하면 된다.

수정한 코드는 다음과 같다.

```java
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();
    Object result = elements[--size];
    elements[size] = null; // 다 쓴 참조 해제
    return result;
}
```

이렇게 참조 해제를 했을 경우, 다 쓴 참조를 사용하려 할 때 NPE를 발생시키기 때문에 오류를 조기에 발견할 수 있다.


모든 상황에서 객체 참조를 null 처리할 필요는 없다.

일반적으로 자기 메모리를 직접 관리하는 클래스에서 메모리 누수에 주의하면 된다.

캐시 역시 메모리 누수를 일으키는 주범 중 하나이다. 객체 참조를 캐시에 넣고 사용 후 꼭 해제해줘야 한다.

또 다른 원인으로는 리스너 혹은 콜백이 있다.

클라이언트가 콜백을 등록만 하고 명확히 해지하지 않는다면 콜백은 계속 쌓이게 된다.

이럴 때 콜백을 약한 참조(weak reference)로 저장하면 가비지 컬렉터가 즉시 수거해간다.



