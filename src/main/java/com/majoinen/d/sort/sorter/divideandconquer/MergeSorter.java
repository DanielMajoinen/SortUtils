package com.majoinen.d.sort.sorter.divideandconquer;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;

import java.util.Comparator;

/**
 * <p>Sorter which uses Merge Sort as its sorting algorithm.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 5/6/17
 */
public class MergeSorter<T extends Comparable<T>> extends
  AbstractSorter<T> {

    private SortableList<T> temp;

    public MergeSorter() {
        temp = new SortableArrayList<>();
    }

    public MergeSorter(Comparator<T> comparator) {
        super(comparator);
        temp = new SortableArrayList<>();
    }

    /**
     * Applies Insertion Sort to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     * @return This returns TRUE at n - 2 iterations, or FALSE otherwise.
     */
    // TODO: Add iteration support for recursive algorithms
    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        mergeSort(0, list.size() - 1, list, comparator);
        return true;
    }

    /**
     * Helper method which recursively splits a list into halves until at
     * single elements, then calls a merge method.
     * @param start The start index of the sub-array to split in half.
     * @param end The end index of the sub-array to split in half.
     * @param list The list of which we're working with.
     * @param comparator An optional comparator to define order.
     */
    private void mergeSort(int start, int end, SortableList<T> list,
      Comparator<T> comparator) {
        if(start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(start, middle, list, comparator);
            mergeSort(middle + 1, end, list, comparator);
            merge(start, middle, end, list, comparator);
        }
    }

    /**
     * Helper method to merge two sub-arrays together into correct order.
     * @param start The start of the first sub-array to merge.
     * @param middle The middle is used to define the end of the first
     *               sub-array and start of the second sub-array.
     * @param end The end of the second sub-array to merge.
     * @param list The list of which we're working with.
     * @param comparator An optional comparator to define order.
     */
    private void merge(int start, int middle, int end, SortableList<T> list,
      Comparator<T> comparator) {
        for (int i = start; i <= end; i++)
            temp.add(i, list.get(i));

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if(lessThan(temp.get(i), temp.get(j), comparator))
                list.set(k, temp.get(i++));
            else
                list.set(k, temp.get(j++));
            k++;
        }

        while (i <= middle)
            list.set(k++, temp.get(i++));
    }
}
