package com.majoinen.d.sort.sorter.divideandconquer;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * <p>Sorter which uses Quick Sort as its sorting algorithm.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 5/6/17
 */
public class QuickSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    private static final Logger logger =
      LogManager.getLogger(QuickSorter.class);
    private static Random random;

    public QuickSorter() {
        random = new Random(System.currentTimeMillis());
    }

    public QuickSorter(Comparator<T> comparator) {
        super(comparator);
        random = new Random(System.currentTimeMillis());
    }

    /**
     * Applies Quick Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     * @return Always return true.
     */
    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        quickSort(0, list.size() - 1, list, comparator);
        return true;
    }

    /**
     * Recursively sort partitions using a random pivot to divide the array.
     * The random pivot is swapped to the first index for partitioning.
     * @param start The start index of the sub-array to sort.
     * @param end The end index of the sub-array to sort.
     * @param list The array to sort.
     * @param comparator An optional comparator to define order.
     */
    private void quickSort(int start, int end, SortableList<T> list,
      Comparator<T> comparator) {
        int partition;
        int pivotIndex = getRandomPivot(start, end);

        if(start != pivotIndex)
            Collections.swap(list, start, pivotIndex);

        partition = partition(start, end, list, comparator);

        if(start < partition - 1)
            quickSort(start, partition - 1, list, comparator);
        if(partition + 1 < end)
            quickSort(partition + 1, end, list, comparator);
    }

    /**
     * Partitions the array into two halves, those that are less than and
     * greater than the pivot value. The first index is used as the pivot,
     * which is then swapped into its appropriate location.
     * @param start The start index of the sub-array to sort.
     * @param end The end index of the sub-array to sort.
     * @param list The array to sort.
     * @param comparator An optional comparator to define order.
     * @return Returns the index of the pivot once it has been swapped into
     * its correct position.
     */
    private int partition(int start, int end, SortableList<T> list,
      Comparator<T> comparator) {
        int left  = start + 1;
        int right = end;
        T   pivot = list.get(start);

        while(left <= right) {
            while (lessThan(list.get(left), pivot, comparator) && left < end)
                left++;
            while (greaterThan(list.get(right), pivot, comparator))
                right--;

            if(left < right)
                Collections.swap(list, left, right);
            else if(left == right)
                left++;
        }

        Collections.swap(list, start, right);
        return right;
    }


    /**
     * Helper method to get a random pivot index from between the provided
     * start and end values.
     * @param start The minimum value the pivot can be.
     * @param end The maximum value the pivot can be.
     * @return A randomised number between start and end (inclusive).
     */
    private int getRandomPivot(int start, int end) {
        return start + random.nextInt(end - start);
    }
}
