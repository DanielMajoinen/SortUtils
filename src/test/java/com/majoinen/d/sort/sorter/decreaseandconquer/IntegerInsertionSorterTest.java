package com.majoinen.d.sort.sorter.decreaseandconquer;

import com.majoinen.d.sort.util.IntegerSortableListTest;
import com.majoinen.d.sort.util.SortableArrayList;
import com.majoinen.d.sort.util.SortableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the Insertion Sort algorithm, using Integer as the element
 * type.
 *
 * @author Daniel Majoinen
 * @version 0.1, 3/6/17
 */
public class IntegerInsertionSorterTest extends IntegerSortableListTest {

    private SortableList<Integer> list;
    private InsertionSorter<Integer> sorter;

    @Before
    public void beforeEachTest() {
        list = new SortableArrayList<>(INT_LIST_1_TO_5); // 3, 1, 5, 2, 4
        sorter = new InsertionSorter<>();
    }

    @Test
    public void sortAll() {
        sorter.sort(list);
        assertTrue(assertAllTrue(list, 1,2,3,4,5));
    }
}