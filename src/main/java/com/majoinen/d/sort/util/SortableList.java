package com.majoinen.d.sort.util;

import com.majoinen.d.sort.sorter.SorterAlgorithm;

import java.util.List;

/**
 * SortableList defines what sort methods are available to the list.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public interface SortableList<T> extends List<T> {

    /**
     * Sort the entire list using the supplied algorithm.
     * @param algorithm The algorithm to use when sorting.
     */
    void sort(SorterAlgorithm algorithm);

    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     */
    void sort(int iterations, SorterAlgorithm algorithm);

    /**
     * Prints each element of the list in its current order.
     */
    void print();
}
