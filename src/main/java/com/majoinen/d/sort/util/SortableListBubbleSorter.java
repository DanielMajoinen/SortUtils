package com.majoinen.d.sort.util;

import java.util.Comparator;

/**
 * <p>Sorter which uses Bubble Sort as its implementation.</p>
 *
 * <p></p>
 * @param <T> The type of objects to order.
 */
public class SortableListBubbleSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    public SortableListBubbleSorter() {
        // Empty constructor for when no default comparator is used
    }

    public SortableListBubbleSorter(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Applies Bubble Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     */
    @Override
    public void singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        // TODO: Implement bubble sort
    }
}
