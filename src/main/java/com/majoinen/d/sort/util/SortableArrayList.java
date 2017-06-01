package com.majoinen.d.sort.util;

import com.majoinen.d.sort.sorter.SorterAlgorithm;
import com.majoinen.d.sort.sorter.SortableListBubbleSorter;
import com.majoinen.d.sort.sorter.SortableListSelectionSorter;
import com.majoinen.d.sort.sorter.Sorter;
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

    private SerializableComparator<T> comparator;

    public SortableArrayList() {
        // Empty constructor for when no comparator is used
    }

    public SortableArrayList(SerializableComparator<T> comparator) {
        this.comparator = comparator;
    }

    public SortableArrayList(List<T> list) {
        this.addAll(list);
    }

    public SortableArrayList(List<T> list,
      SerializableComparator<T> comparator) {
        this.addAll(list);
        this.comparator = comparator;
    }

    /**
     * Sort the entire list using the supplied algorithm.
     * @param algorithm The algorithm to use when sorting.
     */
    @Override
    public void sort(SorterAlgorithm algorithm) {
        Sorter<T> sorter = getAppropriateSorter(algorithm);
        sorter.sort(this);
    }

    /**
     * Sort the list up to a specific number of iterations using the supplied
     * algorithm.
     * @param iterations Number of sorting iterations to complete.
     * @param algorithm The algorithm to use when sorting.
     */
    @Override
    public void sort(int iterations, SorterAlgorithm algorithm) {
        Sorter<T> sorter = getAppropriateSorter(algorithm);
        sorter.sort(iterations,this);
    }

    // TODO: Abstract to own SorterBuilder
    private Sorter<T> getAppropriateSorter(SorterAlgorithm algorithm) {
        if(algorithm == null)
            throw new NullPointerException("SorterAlgorithm cannot be null");

        switch (algorithm) {
            case SELECTION:
                if(comparator == null)
                    return new SortableListSelectionSorter<>();
                else
                    return new SortableListSelectionSorter<>(comparator);
            case BUBBLE:
                if(comparator == null)
                    return new SortableListBubbleSorter<>();
                else
                    return new SortableListBubbleSorter<>(comparator);
            default:
                throw new NullPointerException("Algorithm does not exist");
        }
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
