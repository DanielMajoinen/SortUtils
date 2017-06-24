package com.majoinen.d.sort.sorter.divideandconquer;

import com.majoinen.d.sort.util.IntegerSortableListTest;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the Merge Sort algorithm, using Integer as the element
 * type.
 *
 * @author Daniel Majoinen
 * @version 1.0, 5/6/17
 */
public class IntegerQuickSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private QuickSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(Arrays.asList(
          15, 21, 1, 25, 12, 6, 8, 3, 5, 19, 10, 18
        ));
        sorter = new QuickSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        assertTrue(list.get(0) == 1
          && list.get(1) == 3
          && list.get(2) == 5
          && list.get(3) == 6
          && list.get(4) == 8
          && list.get(5) == 10
          && list.get(6) == 12
          && list.get(7) == 15
          && list.get(8) == 18
          && list.get(9) == 19
          && list.get(10) == 21
          && list.get(11) == 25);
    }
}