package com.majoinen.d.sort.util;

import java.util.Comparator;

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
     * Sort the entire specified SortableList using the specified Comparator.
     * @param list The SortableList to sort.
     * @param comparator The Comparator to define the order.
     */
    void sort(SortableList<T> list, Comparator<T> comparator);

    /**
     * Sort the specified SortableList for the specified amount of iterations.
     * @param iterations How many iterations to complete before stopping.
     * @param list The SortableList to sort.
     */
    void sort(int iterations, SortableList<T> list);

    /**
     * Sort the specified SortableList for the specified amount of iterations
     * using the provided Comparator.
     * @param iterations How many iterations to complete before stopping.
     * @param list The SortableList to sort.
     * @param comparator The Comparator to define the order.
     */
    void sort(int iterations, SortableList<T> list, Comparator<T> comparator);
}
