package com.majoinen.d.sort.util;

import com.majoinen.d.sort.sorter.SorterAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Sort a SortableArrayList without using a comparator to define order.
 *
 * @author Daniel Majoinen
 * @version 1.0, 2/6/17
 */
public class IntegerSortableArrayListETBubbleSortTest
  extends IntegerSortableListTest {

    private SortableArrayList<Integer> list;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(INT_LIST_1_TO_5);
    }

    @Test
    public void sortAll() {
        list.sort(SorterAlgorithm.ET_BUBBLE);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }
}
