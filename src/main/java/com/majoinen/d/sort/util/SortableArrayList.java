package com.majoinen.d.sort.util;

import com.majoinen.d.sort.sorter.Sorter;
import com.majoinen.d.sort.sorter.SorterAlgorithm;
import com.majoinen.d.sort.sorter.SorterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>SortableArrayList is an ArrayList with the added ability to sort with any
 * algorithm in SorterAlgorithm. It has the added ability to stop sorting after
 * a specified amount of iterations, as well as specifying a comparator to
 * handle order when sorting.</p>
 *
 * <p>This was created as revision for my algorithms course exam - Mid 2017.</p>
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public class SortableArrayList<T extends Comparable<T>> extends ArrayList<T>
  implements SortableList<T> {

    private static final Logger logger =
      LogManager.getLogger(SortableArrayList.class);

    private SorterFactory<T> sorterFactory;

    public SortableArrayList() {
        sorterFactory = new SorterFactory<>();
    }

    public SortableArrayList(List<T> list) {
        this.addAll(list);
        sorterFactory = new SorterFactory<>();
    }

    public SortableArrayList(SerializableComparator<T> comparator) {
        sorterFactory = new SorterFactory<>(comparator);
    }

    public SortableArrayList(List<T> list,
      SerializableComparator<T> comparator) {
        this.addAll(list);
        sorterFactory = new SorterFactory<>(comparator);
    }

    /**
     * Sort the entire list using the supplied algorithm.
     * @param algorithm The algorithm to use when sorting.
     */
    @Override
    public void sort(SorterAlgorithm algorithm) {
        Sorter<T> sorter = sorterFactory.getSorter(algorithm);
        sorter.sort(this);
    }

    /**
     * Sort the entire list using the specified algorithm and comparator.
     * Specifying a comparator overrides the default.
     * @param algorithm The algorithm to use when sorting.
     * @param comparator The comparator to use when sorting - Overrides default.
     */
    @Override
    public void sort(SorterAlgorithm algorithm,
      SerializableComparator<T> comparator) {
        Sorter<T> sorter = sorterFactory.getSorter(algorithm);
        sorter.sort(this, comparator);
    }

    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     */
    @Override
    public void sort(int iterations, SorterAlgorithm algorithm) {
        Sorter<T> sorter = sorterFactory.getSorter(algorithm);
        sorter.sort(iterations,this);
    }

    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm and comparator. Specifying a comparator overrides the default.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     * @param comparator The comparator to use when sorting - Overrides default.
     */
    @Override
    public void sort(int iterations, SorterAlgorithm algorithm,
      SerializableComparator<T> comparator) {
        Sorter<T> sorter = sorterFactory.getSorter(algorithm);
        sorter.sort(iterations,this, comparator);
    }

    /**
     * Prints each element of the list in its current order.
     */
    @Override
    public void print() {
        String output = "";
        for(T element : this)
            output = output.concat(element+" ");
        logger.info("List: " + output);
    }

    /**
     * Defines if two SortableArrayList's are equal.
     * @param obj The object to compare to.
     * @return Returns TRUE if is the same object, all indexes values match,
     \ or FALSE otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        SortableArrayList other = (SortableArrayList) obj;
        if(this.size() != other.size()) {
            return false;
        }
        for(int i = 0; i < this.size(); i++) {
            if(other.get(i).equals(this.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Defines the HashCode for the SortableArrayList instance.
     * @return The HashCode in the form of an int.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
