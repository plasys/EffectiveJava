package Chapter05.Item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyStack<E> {

    private ArrayList<E> al = new ArrayList<>();

    public void push(E e) {
        al.add(e);
    }

    public E pop() {
        E r = al.get(al.size()-1);
        al.remove(al.size()-1);
        return r;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    public void popAll(Collection<? super E> dst) {
        while (!al.isEmpty())
            dst.add(pop());
    }


}
