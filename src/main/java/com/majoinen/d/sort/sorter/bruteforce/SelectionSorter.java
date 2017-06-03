package com.majoinen.d.sort.sorter.bruteforce;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableList;

import java.util.Collections;
import java.util.Comparator;

/**
 * <p>Sorter which uses Selection Sort as its implementation.</p>
 *
 * <p>1. Scan all n elements of the array to find the smallest element, and swap
 * it with the first element.
 * 2. Starting with the second element, scan the remaining n-1 elements to find
 * the smallest element and swap it with the element in the second position.
 * 3. Repeat until sorted.</p>
 * @param <T> The type of objects to order.
 */
public class SelectionSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    public SelectionSorter() {
        // Empty constructor for when no default comparator is used
    }

    public SelectionSorter(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Applies Selection Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     * @return This returns TRUE at n - 2 iterations, or FALSE otherwise.
     */
    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        // Set smallestIndex to the first item we check each iteration
        int smallestIndex = iteration;

        // Loop over all elements not already sorted, searching for smallest
        for(int i = iteration; i < list.size(); i++) {
            if(lessThan(list.get(i), list.get(smallestIndex), comparator)) {
                smallestIndex = i;
            }
        }

        // If the swap index is not already in the correct position, swap...
        if(smallestIndex != iteration) {
            Collections.swap(list, smallestIndex, iteration);
        }
        // Stop at n - 2 iterations, where n is the size of input
        // Note: iteration count is zero-based
        return iteration == list.size() - 2;
    }
}
