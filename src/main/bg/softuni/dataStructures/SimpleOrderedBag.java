package main.bg.softuni.dataStructures;

import java.util.Collection;

public interface SimpleOrderedBag<E extends Comparable<E>> extends Iterable<E> {

    int capacity();

    boolean remove(E element);

    void add(E element);

    void addAll(Collection<E> elements);

    int size();

    String joinWith(String joiner);
}
