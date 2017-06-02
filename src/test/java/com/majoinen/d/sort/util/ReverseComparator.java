package com.majoinen.d.sort.util;

/**
 * Comparator that is used to order from largest to smallest.
 *
 * @author Daniel Majoinen
 * @version 1.0, 2/6/17
 */
public class ReverseComparator<T extends Comparable<T>> implements
  SerializableComparator<T> {

    @Override
    public int compare(T a, T b) {
        int comparison = a.compareTo(b);
        if(comparison < 0)
            return 1;
        else if(comparison > 0)
            return -1;
        else
            return 0;
    }
}
