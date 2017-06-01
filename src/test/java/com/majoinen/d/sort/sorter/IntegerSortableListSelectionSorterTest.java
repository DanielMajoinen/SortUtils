package com.majoinen.d.sort.sorter;

import com.majoinen.d.sort.util.IntegerSortableListTest;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the SelectionSort algorithm, using Integer as the element
 * type.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public class IntegerSortableListSelectionSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private SortableListSelectionSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(INT_LIST_1_TO_5);
        sorter = new SortableListSelectionSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }

    @Test
    public void sort1Iteration() {
        sorter.sort(1, list);
        assertTrue(assertAllTrue(list, 1,3,5,2,4));
    }

    @Test
    public void sort2Iterations() {
        sorter.sort(2, list);
        assertTrue(assertAllTrue(list, 1,2,5,3,4));
    }

    @Test
    public void sort3Iterations() {
        sorter.sort(3, list);
        assertTrue(assertAllTrue(list, 1,2,3,5,4));
    }

    @Test
    public void sort4Iterations() {
        sorter.sort(4, list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }


}
