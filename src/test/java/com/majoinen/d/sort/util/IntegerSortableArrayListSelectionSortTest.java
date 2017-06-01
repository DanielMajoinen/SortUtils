package com.majoinen.d.sort.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for SortableArrayList using Integer as the element type.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public class IntegerSortableArrayListSelectionSortTest extends IntegerSortableListTest {

    private SortableArrayList<Integer> list;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(INT_LIST_1_TO_5);
    }

    @Test
    public void add() {
        list.add(0, 10);
        assertTrue(list.get(0) == 10);
        assertFalse(list.isEmpty());
    }

    @Test
    public void remove() {
        list.add(0, 10);
        assertTrue(list.get(0) == 10);
        list.remove(0);
        assertTrue(list.get(0) != 10);
    }

    @Test
    public void sortAll() {
        list.sort(SortAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }

    @Test
    public void sort1Iteration() {
        list.sort(1, SortAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 1,3,5,2,4));
    }

    @Test
    public void sort2Iterations() {
        list.sort(2, SortAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 1,2,5,3,4));
    }

    @Test
    public void sort3Iterations() {
        list.sort(3, SortAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 1,2,3,5,4));
    }

    @Test
    public void sort4Iterations() {
        list.sort(4, SortAlgorithm.SELECTION);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }
}
