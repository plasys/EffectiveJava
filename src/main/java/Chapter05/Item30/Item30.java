package Chapter05.Item30;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class Item30 {

    public static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

//    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static <T extends Comparable<T>> T max(Collection<T> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Collection is empty.");

        T result = null;

        for (T t : c)
            if (result == null || t.compareTo(result) > 0)
                result = Objects.requireNonNull(t);

        return result;
    }

    public static void main(String[] args) {
        UnaryOperator<String> a = identityFunction();

        String b = a.apply("hi");

        System.out.println(b);

        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(3);
        al.add(99);

        Integer r = max(al);

        System.out.println(r);

    }
}
