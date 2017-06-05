package com.majoinen.d.sort.sorter.decreaseandconquer;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Sorter which uses Shell Sort as its sorting algorithm.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 3/6/17
 */
public class ShellSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    private List<Integer> gaps;

    public ShellSorter() {
        gaps = new ArrayList<>();
    }

    public ShellSorter(Comparator<T> comparator) {
        super(comparator);
        gaps = new ArrayList<>();
    }

    /**
     * Applies Shell Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     * @return This returns TRUE at n - 2 iterations, or FALSE otherwise.
     */
    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        if(iteration == FIRST_ITERATION)
            prepareGaps(list.size());

        // Define this iterations gap size
        int gap = gaps.remove(0);

        // Iterate over elements between gap size - the delta
        for (int i = 0; i < gap; i++) {
            // To sort for this gap size we require n / gap sub-iterations
            for (int j = 0; j < list.size()
              && ((j * gap) + i) <= list.size() - 1; j++) {
                // Determine index with delta applied
                int k = (j * gap) + i;
                // Apply insertion sort on sub-array
                insertionSortSubarray(k, gap, list, comparator);
            }
        }
        // Terminate when gap size has been reduced to 1
        // At this point Insertion sort has been applied
        return gap == 1;
    }

    /**
     * Helper method to apply insertion sort on a subarray.
     * @param i A index for all elements up to, and including, are sorted.
     * @param gap The gap between elements in the subarray.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     */
    private void insertionSortSubarray(int i, int gap, SortableList<T> list,
      Comparator<T> comparator) {
        while (i >= 0 && i + gap <= list.size() - 1) {
            if(greaterThan(list.get(i), list.get(i + gap), comparator))
                Collections.swap(list, i, i + gap);
            i -= gap;
        }
    }

    /**
     * Helper method to define gap increments. Gaps increment at (3x + 1) where
     * x is the previous gap, as long as at least 3 elements will be sorted.
     * @param size The size of the list that is being sorted.
     */
    private void prepareGaps(int size) {
        int gap = 1;
        while(gap <= size / 3) {
            gaps.add(0, gap);
            gap = 3 * gap + 1;
        }
    }
}
