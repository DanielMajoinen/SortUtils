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
public class IntegerMergeSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private MergeSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(Arrays.asList(
          54, 26, 93, 17, 77, 31, 44, 55, 20
        ));
        sorter = new MergeSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        assertTrue(list.get(0) == 17
          && list.get(1) == 20
          && list.get(2) == 26
          && list.get(3) == 31
          && list.get(4) == 44
          && list.get(5) == 54
          && list.get(6) == 55
          && list.get(7) == 77
          && list.get(8) == 93);
    }

    @Test
    public void sort1Iteration() {
        sorter.sort(1, list);
        assertTrue(list.get(0) == 26
          && list.get(1) == 54
          && list.get(2) == 17
          && list.get(3) == 93
          && list.get(4) == 31
          && list.get(5) == 77
          && list.get(6) == 44
          && list.get(7) == 20
          && list.get(8) == 55);
    }

    @Test
    public void sort2Iterations() {
        sorter.sort(2, list);
        assertTrue(list.get(0) == 17
          && list.get(1) == 26
          && list.get(2) == 54
          && list.get(3) == 93
          && list.get(4) == 31
          && list.get(5) == 77
          && list.get(6) == 20
          && list.get(7) == 44
          && list.get(8) == 55);
    }

    @Test
    public void sort3Iterations() {
        sorter.sort(3, list);
        assertTrue(list.get(0) == 17
          && list.get(1) == 26
          && list.get(2) == 54
          && list.get(3) == 93
          && list.get(4) == 20
          && list.get(5) == 31
          && list.get(6) == 44
          && list.get(7) == 55
          && list.get(8) == 77);
    }

    @Test
    public void sort4Iterations() {
        sorter.sort(4, list);
        assertTrue(list.get(0) == 17
          && list.get(1) == 20
          && list.get(2) == 26
          && list.get(3) == 31
          && list.get(4) == 44
          && list.get(5) == 54
          && list.get(6) == 55
          && list.get(7) == 77
          && list.get(8) == 93);
    }
}