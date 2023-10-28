package org.example;

import java.util.*;
import java.util.stream.Stream;

public class MyClass {

    private static final Map<String, MyClass> days = new HashMap<>();

    private final String day;

    private MyClass(String d) {
        this.day = d;
    }

    static {
        days.put("월", new MyClass("m"));
        days.put("화", new MyClass("t"));
        days.put("수", new MyClass("w"));
        days.put("목", new MyClass("t"));
        days.put("금", new MyClass("f"));
    }

    public static MyClass from(String d){
        return days.get(d);
    }

    public String getDay() {
        return day;
    }

    public static List<MyClass> of(String ... strings) {
        List<MyClass> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            list.add(days.get(strings[i]));
        }

        return list;
    }
//    public static MyClass newMyClass() {
//        return new MyClass();
//    }
    
    public static void main(String[] args) {

        MyClass m = MyClass.from("월");
        MyClass m2 = MyClass.from("월");

        System.out.println(m.equals(m2));

        List<MyClass> days = MyClass.of("1","화","수");

        System.out.println(days);
    }
}
