package com.majoinen.d.sort.sorter.bruteforce;

import com.majoinen.d.sort.sorter.bruteforce.SortableListETBubbleSorter;
import com.majoinen.d.sort.util.IntegerSortableListTest;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the Early Termination Bubble Sort algorithm, using Integer as
 * the element type.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public class IntegerSortableListETBubbleSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private SortableListETBubbleSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(INT_LIST_1_TO_5); // 3, 1, 5, 2, 4
        sorter = new SortableListETBubbleSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }

    @Test
    public void sort1Iteration() {
        sorter.sort(1, list);
        assertTrue(assertAllTrue(list, 1,3,2,4,5));
    }

    @Test
    public void sort2Iterations() {
        sorter.sort(2, list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }

    @Test
    public void sort3Iterations() {
        sorter.sort(3, list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }

    @Test
    public void sort4Iterations() {
        sorter.sort(4, list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }
}
