# try-finally보다는 try-with-resources를 사용하라

자바 라이브러리에서는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많다.

전통적으로 자원이 제대로 닫힘을 보장하는 수단으로 try-finally가 쓰였다.

try-finally 문을 사용하는 경우에는 try문에서 발생하는 예외가 finally문에서 발생할 수 있는 예외에 묻혀버리게 되는 경우가 생긴다.

```java
static String firstLineOfFile(String path) throws IOException {
    BurreredReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();
    } finally {
        br.close();
    }
}
```

위 코드의 경우에서, readLine() 메서드에서 예외가 발생했을 경우 스택 추적 내역에서는 finally 문에서 발생한 예외에 대한 정보만 남게 된다.


이 문제는 try-with-resources를 사용하면 해결된다.


```java
static String firstLineOfFile(String path) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
    } catch (IOException e) {
        //...
    }
}
```

try-finally를 사용했을 때보다 코드도 더 간결하고, 발생한 모든 예외들을 스택 추적 내역에서 확인할 수 있다.

catch절 또한 사용할 수 있다.

꼭 회수해야 하는 자원을 다룰 때는 무조건 try-with-resource를 사용하자.
