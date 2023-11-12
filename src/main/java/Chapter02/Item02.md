# 생성자에 매개변수가 많다면 빌더를 고려하라

생성자와 정적 팩토리 메서드를 사용할 때 매개변수가 많아지면 인스턴스를 만드는데 번거로움이 생긴다.

자바빈즈는 setter를 사용해서 인스턴스를 생성한다. 그러나 세터 메서드를 여러개 호출해야 함
객체가 완전히 생성되기 전까지는 일관성(?)이 무너진 상태에 놓이게 됨

이런 단점들을 보완한 빌더 패턴이 있다.
필요한 매개변수만 선택해서 호출하여 인스턴스를 생성한다.
또한 불변 객체이므로 안전함.

```java

public class Post {

    private final Long id;
    private final String title;
    private final String content;

    public static class Builder {
        private Long id = 0;
        private String title = "";
        private String content = "";
  
        public Builder() {}
  
        public Builder id(Long id) {
          this.id = id;
          return this;
        }
  
        public Builder title(String title) {
          this.title = title;
          return this;
        }
        
        public Builder content(String content) {
          this.content = content;
          return this;
        }
  
        public Post build() {
          return new Post(this);
        }
    }

    private Post(Builder builder) {
        id = builder.id;
        title = builder.title;
        content = builder.content;
    }

}

```

인스턴스를 생성할 때 다음과 같이 작성하면 된다.

```java
  Post post = new Post.Builder()
                  .id(1)
                  .title("Hello")
                  .content("Hello World")
                  .build();
```

만약 content에 아무것도 넣지 않으려면 content 부분을 제외하고 인스턴스를 생성하면 된다.

```java
  Post post = new Post.Builder()
                  .id(1)
                  .title("Hello")
                  .build();
```

굳이 단점이라면 매개변수를 추가하는 코드가 좀 길어지고 매번 빌더를 만들어야 한다는 점이 있지만
많은 매개변수를 사용하고, 또 필수가 아닌 매개변수들을 받는 상황에서는 생성자보다 훨씬 편리하다.
