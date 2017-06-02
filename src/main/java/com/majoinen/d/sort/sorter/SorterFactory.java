package com.majoinen.d.sort.sorter;

import com.majoinen.d.sort.sorter.bruteforce.BubbleSorter;
import com.majoinen.d.sort.sorter.bruteforce.ETBubbleSorter;
import com.majoinen.d.sort.sorter.bruteforce.SelectionSorter;
import com.majoinen.d.sort.util.SerializableComparator;

import java.io.Serializable;

/**
 * SorterFactory's single purpose is to instantiate an appropriate sorter for
 * a specified algorithm. This is used when sorting a SortableArrayList.
 *
 * @author Daniel Majoinen
 * @version 0.1, 2/6/17
 */
public class SorterFactory<T extends Comparable<T>> implements Serializable {

    private static final long serialVersionUID = 1074200460058548317L;
    private SerializableComparator<T> comparator;

    public SorterFactory() {
        // Empty constructor for when no comparator is used
    }

    public SorterFactory(SerializableComparator<T> comparator) {
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

        Sorter<T> sorter;
        switch (algorithm) {
            case SELECTION:
                if (comparator == null)
                    sorter = new SelectionSorter<>();
                else
                    sorter = new SelectionSorter<>(comparator);
                break;
            case BUBBLE:
                if (comparator == null)
                    sorter = new BubbleSorter<>();
                else
                    sorter = new BubbleSorter<>(comparator);
                break;
            case ET_BUBBLE:
                if (comparator == null)
                    sorter = new ETBubbleSorter<>();
                else
                    sorter = new ETBubbleSorter<>(comparator);
                break;
            default:
                throw new NullPointerException("Algorithm not found");
        }
        return sorter;
    }
}
