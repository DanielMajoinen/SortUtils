package com.majoinen.d.sort.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * [Class Description]
 *
 * @author Daniel Majoinen
 * @version 1.0, 2/6/17
 */
public class IntegerSortableArrayListTest extends IntegerSortableListTest {

    private SortableArrayList<Integer> list;

    @Test
    public void emptyConstructor() {
        list = new SortableArrayList<>();

        assertTrue(list.isEmpty());
        list.add(1);
        assertTrue(!list.isEmpty());
        assertTrue(list.get(0) == 1);
    }

    @Test
    public void defaultComparator() {
        ReverseComparator<Integer> comparator = new ReverseComparator<>();
        list = new SortableArrayList<>(comparator);

        assertTrue(list.isEmpty());
        list.add(1);
        assertTrue(!list.isEmpty());
        assertTrue(list.get(0) == 1);
    }

    @Test
    public void print() {
        list = new SortableArrayList<>();

        assertTrue(list.isEmpty());
        list.add(1);
        assertTrue(!list.isEmpty());
        assertTrue(list.get(0) == 1);
        list.print();
    }

    @Test
    public void equal() {
        list = new SortableArrayList<>();
        assertTrue(list.isEmpty());
        list.add(1);

        SortableArrayList<Integer> list2 = list;
        SortableArrayList<Integer> list3 = new SortableArrayList<>(list2);

        assertTrue(list.equals(list2));
        assertFalse(list2.equals(list3));
    }
}
