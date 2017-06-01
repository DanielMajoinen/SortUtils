package com.majoinen.d.sort.util;

/**
 * Sorter defines what sort methods are required for each sorting algorithm
 * implementation.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public interface Sorter<T> {

    /**
     * Sort the entire specified SortableList.
     * @param list The SortableList to sort.
     */
    void sort(SortableList<T> list);

    /**
     * Sort the specified SortableList for the specified amount of iterations.
     * @param iterations How many iterations to complete before stopping.
     * @param list The SortableList to sort.
     */
    void sort(int iterations, SortableList<T> list);
}
