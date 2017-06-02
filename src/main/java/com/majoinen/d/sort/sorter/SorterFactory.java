package com.majoinen.d.sort.sorter;

import com.majoinen.d.sort.sorter.bruteforce.BubbleSorter;
import com.majoinen.d.sort.sorter.bruteforce.ETBubbleSorter;
import com.majoinen.d.sort.sorter.bruteforce.SelectionSorter;

import java.util.Comparator;

/**
 * SorterFactory's single purpose is to instantiate an appropriate sorter for
 * a specified algorithm. This is used when sorting a SortableArrayList.
 *
 * @author Daniel Majoinen
 * @version 0.1, 2/6/17
 */
public class SorterFactory<T extends Comparable<T>> {

    private Comparator<T> comparator;

    public SorterFactory() {
        // Empty constructor for when no comparator is used
    }

    public SorterFactory(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Instantiates an appropriate sorter for the specified algorithm.
     * @param algorithm The algorithm which the sorter should use.
     * @return Returns a Sorter object for the specified algorithm, or throws
     \ a NullPointerException.
     */
    public Sorter<T> getSorter(SorterAlgorithm algorithm) {
        if(algorithm == null)
            throw new NullPointerException("SorterAlgorithm cannot be null");

        switch (algorithm) {
            case SELECTION:
                if (comparator == null)
                    return new SelectionSorter<>();
                else
                    return new SelectionSorter<>(comparator);
            case BUBBLE:
                if (comparator == null)
                    return new BubbleSorter<>();
                else
                    return new BubbleSorter<>(comparator);
            case ET_BUBBLE:
                if (comparator == null)
                    return new ETBubbleSorter<>();
                else
                    return new ETBubbleSorter<>(comparator);
            default:
                throw new NullPointerException("Algorithm does not exist");
        }
    }

}
