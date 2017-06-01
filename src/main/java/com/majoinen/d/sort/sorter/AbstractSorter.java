package com.majoinen.d.sort.sorter;

import com.majoinen.d.sort.util.SortableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

/**
 * Provide multiple variations of sort methods to client, without duplicating
 * code.
 *
 * @author Daniel Majoinen
 * @version 0.1, 1/6/17
 */
public abstract class AbstractSorter<T> implements Sorter<T> {

    private static final Logger logger =
      LogManager.getLogger(AbstractSorter.class);

    private Comparator<T> defaultComparator;

    public AbstractSorter() { }

    public AbstractSorter(Comparator<T> comparator) {
        this.defaultComparator = comparator;
    }

    /**
     * Getter for the default comparator specified on instantiation.
     * @return Returns the comparator object specified on instantiation, or
     \ NULL.
     */
    public Comparator<T> getDefaultComparator() {
        return defaultComparator;
    }

    /**
     * Sort the entire specified SortableList.
     * @param list The SortableList to sort.
     */
    @Override
    public void sort(SortableList<T> list) {
        sort(list.size(), list, null);
    }

    /**
     * Sort the entire specified SortableList using the specified Comparator.
     * @param list The SortableList to sort.
     * @param comparator The Comparator to define the order.
     */
    @Override
    public void sort(SortableList<T> list, Comparator<T> comparator) {
        sort(list.size(), list, comparator);
    }

    /**
     * Sort the specified SortableList for the specified amount of iterations.
     * @param totalIterations How many iterations to complete before stopping.
     * @param list The SortableList to sort.
     */
    @Override
    public void sort(int totalIterations, SortableList<T> list) {
        sort(totalIterations, list, null);
    }

    /**
     * Sort the specified SortableList for the specified amount of iterations
     * using the provided Comparator.
     * @param totalIterations How many iterations to complete before stopping.
     * @param list The SortableList to sort.
     * @param comparator The Comparator to define the order.
     */
    @Override
    public void sort(int totalIterations, SortableList<T> list,
      Comparator<T> comparator) {
        logger.info("Sorting list using SelectionSort");
        list.print();
        for(int iteration = 0; iteration < totalIterations; iteration++) {
            logger.info("Iteration: " + (iteration + 1));
            if(comparator != null) {
                singleIteration(iteration, list, comparator);
            } else if(getDefaultComparator() != null) {
                singleIteration(iteration, list, getDefaultComparator());
            } else {
                singleIteration(iteration, list, null);
            }
            list.print();
        }
    }

    /**
     * Applies the sorting algorithm to the list of data for a single iteration.
     * @param iteration The current iteration count.
     * @param list The list of data to sort.
     * @param comparator An optional comparator to define order.
     */
    public abstract void singleIteration(int iteration, SortableList<T> list,
      Comparator<T> comparator);
}
