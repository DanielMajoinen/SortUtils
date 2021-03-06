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
     * Sort the entire list using the specified algorithm and comparator.
     * @param algorithm The algorithm to use when sorting.
     * @param comparator The comparator to use when sorting - Overrides default.
     */
    void sort(SorterAlgorithm algorithm, SerializableComparator<T> comparator);

    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     */
    void sort(int iterations, SorterAlgorithm algorithm);


    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm and comparator. Specifying a comparator overrides the default.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     * @param comparator The comparator to use when sorting - Overrides default.
     */
    void sort(int iterations, SorterAlgorithm algorithm,
      SerializableComparator<T> comparator);

    /**
     * Prints each element of the list in its current order.
     */
    void print();
}
