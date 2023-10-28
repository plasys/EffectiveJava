package org.example;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        List a = new ArrayList(List.of(5, 1, 3, 4, 2));
        System.out.println("a = " + a);
        Collections.sort(a);
        System.out.println("a = " + a);
        Calendar c = Calendar.getInstance();
        Calendar d = Calendar.getInstance();

        System.out.println(c);
        System.out.println(d);

//        MyClass m = new MyClass();

    }
}