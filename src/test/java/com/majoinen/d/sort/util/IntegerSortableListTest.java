package com.majoinen.d.sort.util;

import java.util.Arrays;
import java.util.List;

/**
 * [Class Description]
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public abstract class IntegerSortableListTest {

    private static final int FIRST_INDEX    = 0;
    private static final int SECOND_INDEX   = 1;
    private static final int THIRD_INDEX    = 2;
    private static final int FOURTH_INDEX   = 3;
    private static final int LAST_INDEX     = 4;

    protected static final List<Integer> INT_LIST_1_TO_5 = Arrays.asList(3,1,5,2,4);

    protected boolean assertAllTrue(List<Integer> list, int first, int second,
      int third, int fourth, int fifth) {
        return (list.get(FIRST_INDEX) == first
          && list.get(SECOND_INDEX)   == second
          && list.get(THIRD_INDEX)    == third
          && list.get(FOURTH_INDEX)   == fourth
          && list.get(LAST_INDEX)     == fifth);
    }
}
