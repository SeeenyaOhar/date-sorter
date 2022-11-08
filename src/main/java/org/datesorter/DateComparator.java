package org.datesorter;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Used for sorting a collection of LocalDate ascending.
 */
public class DateComparator implements Comparator<LocalDate> {

    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        if (o1.isAfter(o2))
            return 1;

        if (o1.isBefore(o2))
            return -1;

        return 0;
    }
}
