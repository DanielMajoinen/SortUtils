package com.majoinen.d.sort.util;

import com.majoinen.d.sort.sorter.SorterAlgorithm;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Sort a SortableArrayList using a comparator to define order.
 *
 * @author Daniel Majoinen
 * @version 1.0, 2/6/17
 */
public class IntegerSortableArrayListSelectionSortComparatorTest
  extends IntegerSortableListTest {

    private SortableArrayList<Integer> list;

    @Before
    public void beforeEachTest() {
        ReverseComparator<Integer> comparator = new ReverseComparator<>();
        list = new SortableArrayList<>(INT_LIST_1_TO_5, comparator);
    }

    @Test
    public void sortAll() {
        list.sort(SorterAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 5,4,3,2,1));
    }
}
