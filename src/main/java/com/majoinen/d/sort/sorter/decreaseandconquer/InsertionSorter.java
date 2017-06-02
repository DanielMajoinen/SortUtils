package com.majoinen.d.sort.sorter.decreaseandconquer;

import com.majoinen.d.sort.sorter.AbstractSorter;
import com.majoinen.d.sort.util.SortableList;

import java.util.Collections;
import java.util.Comparator;

/**
 * <p>Sorter which uses Insertion Sort as its implementation.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 3/6/17
 */
public class InsertionSorter<T extends Comparable<T>> extends AbstractSorter<T> {

    public InsertionSorter() {
        // Empty constructor for when no default comparator is used
    }

    public InsertionSorter(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public boolean singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator) {
        int i = iteration;
        while (i >= 0 && greaterThan(list.get(i), list.get(i+1), comparator)) {
            Collections.swap(list, i, i+1);
            i--;
        }
        // Stop at n - 1 iterations, where n is the size of input
        // Note: iteration count is zero-based, hence the + 1
        return iteration + 1 == list.size() - 1;
    }
}
