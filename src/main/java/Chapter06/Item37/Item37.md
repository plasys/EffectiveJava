# ordinal 인덱싱 대신 EnumMap을 사용하라

EnumMap은 열거 타입을 키로 사용하도록 설계한 Map 구현체이다.

배열의 인덱스를 얻기 위해 ordinal을 쓰는 것은 일반적으로 좋지 않으니, 대신 EnumMap을 사용하는 것이 좋다.

(Enum.ordinal은 웬만하면 사용하지 말 것)