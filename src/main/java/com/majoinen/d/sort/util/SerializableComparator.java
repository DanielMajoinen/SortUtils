package com.majoinen.d.sort.util;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A serializable comparator class for use in the SortableList.
 * This keeps the entire hierarchy serializable.
 *
 * @author Daniel Majoinen
 * @version 1.0, 1/6/17
 */
public interface SerializableComparator<T> extends Comparator<T>, Serializable {

}
