package com.majoinen.d.sort.sorter.decreaseandconquer;

import com.majoinen.d.sort.util.IntegerSortableListTest;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the Shell Sort algorithm, using Integer as the element
 * type.
 *
 * @author Daniel Majoinen
 * @version 1.0, 3/6/17
 */
public class IntegerShellSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private ShellSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(Arrays.asList(
          13, 19, 15, 17, 5, 11, 7, 20, 12, 3,
          6, 9, 1, 16, 10, 14, 8, 18, 2, 4
        ));
        sorter = new ShellSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) == list.get(i + 1) - 1);
        }
    }

    @Test
    public void sort1Iteration() {
        List<Integer> singleIteration = Arrays.asList(
          1, 3, 2, 4, 5, 11, 6, 9, 8, 16,
          7, 14, 12, 18, 10, 17, 13, 19, 15, 20
        );
        sorter.sort(1, list);
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i).equals(singleIteration.get(i)));
        }
    }

    @Test
    public void sort2Iterations() {
        sorter.sort(2, list);
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) == list.get(i + 1) - 1);
        }
    }
}