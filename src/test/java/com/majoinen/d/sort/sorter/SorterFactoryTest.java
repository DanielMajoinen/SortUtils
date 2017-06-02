package com.majoinen.d.sort.sorter;

import org.junit.Before;
import org.junit.Test;


/**
 * Unit tests for SorterFactoryTest concrete class.
 *
 * @author Daniel Majoinen
 * @version 1.0, 2/6/17
 */
public class SorterFactoryTest<T extends Comparable<T>> {

    private SorterFactory<T> sorterFactory;

    @Before
    public void beforeEachTest() {
        sorterFactory = new SorterFactory<>();
    }

    @Test(expected=NullPointerException.class)
    public void getNullSorter() {
        sorterFactory.getSorter(null);
    }

    // TODO: Remove once all algorithms are implemented
    @Test(expected=NullPointerException.class)
    public void getSelectionSorter() {
        sorterFactory.getSorter(SorterAlgorithm.DISTRIBUTION);
    }
}
