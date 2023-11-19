package Chapter02;

import java.util.*;

public class Day {

    // 요일을 저장할 HashMap
    private static final Map<String, Day> days = new HashMap<>();

    // 무슨 요일인지 String으로 저장
    private final String day;

    // 생성자의 접근제어자를 private로 설정하고 팩토리 메서드를 통해서만 객체를 생성할 수 있도록 함
    private Day(String d) {
        this.day = d;
    }

    // 초기화할 때 모든 요일을 생성해서 map에 저장
    static {
        days.put("월", new Day("monday"));
        days.put("화", new Day("tuesday"));
        days.put("수", new Day("wednesday"));
        days.put("목", new Day("thursday"));
        days.put("금", new Day("friday"));
        days.put("토", new Day("saturday"));
        days.put("일", new Day("sunday"));
    }

    // 'from' 은 하나의 매개변수로 같은 타입의 인스턴스를 반환
    public static Day from(String d){
        return days.get(d);
    }

    // 'getType'은 본 클래스와 다른 클래스를 생성해서 반환할 때 사용
    public String getDay() {
        return day;
    }

    /*
        'of' 는 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
        요일 여러개를 한글로 받아서(배열에 받음) map에 저장된 요일(String)을 list에 담아서 반환
    */
    public static List<Day> of(String ... strings) {

        List<Day> list = new ArrayList<>();

        for (String s : strings) {
            list.add(days.get(s));
        }

        return list;
    }
//    public static MyClass newMyClass() {
//        return new MyClass();
//    }
    
    public static void main(String[] args) {

        Day m = Day.from("월");
        Day m2 = Day.from("월");

        System.out.println(m == m2); // 두 객체가 같음

        // from
        System.out.println("m.from(\"월\") = " + m.from("월").getDay());
        System.out.println("m.from(\"화\") = " + m.from("화").getDay());

        // of
        List<Day> days = Day.of("월", "화", "수", "목");
        days.forEach(d -> System.out.println(d.getDay()));


    }
}
