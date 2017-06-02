package com.majoinen.d.sort.sorter.bruteforce;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableList;

import java.util.Collections;
import java.util.Comparator;

/**
 * <p>Sorter which uses Early Termination Bubble Sort as its implementation.</p>
 *
 * <p>1.First iteration, compare each adjacent pair of elements and swap them
 * if they are out of order. Eventually the largest element gets propagated to
 * the end.
 * 2. Second iteration, repeat the process, but only from the first to the 2nd
 * last element. Eventually second largest element is at the 2nd last element.
 * 3. Repeat until all elements are sorted.
 * 4. If any iteration it is the case that no pairs are required to
 * be swapped, the sorting is done and will terminate early.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 * @param <T> The type of objects to order.
 */
public class ETBubbleSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    public ETBubbleSorter() {
        // Empty constructor for when no default comparator is used
    }

    public ETBubbleSorter(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Applies Bubble Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     */
    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        int swaps = 0;
        // Loop through all elements, stopping at previously sorted elements
        for (int i = 0; i < list.size() - 1 - iteration; i++) {
            // Swap when needed to make largest element rise to top
            if(greaterThan(list.get(i), list.get(i + 1), comparator)) {
                Collections.swap(list, i, i + 1);
                swaps++;
            }
        }
        // If no swaps were done on an iteration, terminate early OR
        // Stop at n - 2 iterations, where n is the size of input
        // Note: iteration count is zero-based, hence the + 1
        return swaps == 0 || iteration + 1 == list.size() - 2;
    }
}
