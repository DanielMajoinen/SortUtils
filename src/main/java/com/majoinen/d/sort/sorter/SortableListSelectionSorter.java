package com.majoinen.d.sort.sorter;

import com.majoinen.d.sort.util.SortableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
public class SortableListSelectionSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    private static final Logger logger =
      LogManager.getLogger(SortableListSelectionSorter.class);

    public SortableListSelectionSorter() {
        // Empty constructor for when no default comparator is used
    }

    public SortableListSelectionSorter(Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Applies Selection Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     * @return Returns the index of the element to swap with.
     */
    @Override
    public void singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        // Set smallestIndex to the first item we check each iteration
        int smallestIndex = iteration;

        // Loop over all elements not already sorted, searching for smallest
        for(int i = iteration; i < list.size(); i++) {
            // If a comparator was provided, use it to order
            if(comparator != null) {
                if(comparator.compare(list.get(i),
                  list.get(smallestIndex)) < 0) {
                    smallestIndex = i;
                }
            }
            // If no comparator was specified, use the list objects compare
            // method to order (T extends Comparable<T>)
            else {
                if(list.get(i).compareTo(list.get(smallestIndex)) < 0) {
                    smallestIndex = i;
                }
            }
        }

        // If the swap index is not already in the correct position, swap...
        if(smallestIndex != iteration) {
            logger.info(String.format("Swapping %s with %s",
              list.get(smallestIndex), list.get(iteration)));
            Collections.swap(list, smallestIndex, iteration);
        }
        // ...Otherwise do nothing
        else {
            logger.info("No need to swap this iteration");
        }
    }
}
