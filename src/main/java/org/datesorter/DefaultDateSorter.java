package org.datesorter;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * The implementation of the date sorter according to the interface specification.
 */
public class DefaultDateSorter implements IDateSorter{
    /**
     * Indicates if the month has an 'r' in the name.
     */
    Map<Month, Boolean> hasR = new HashMap<>();
    DateComparator dateComparator = new DateComparator();
    ReverseDateComparator reverseDateComparator = new ReverseDateComparator();
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (hasR.isEmpty()){
            initializeMap();
        }

        if (unsortedDates.isEmpty()){
            throw new IllegalArgumentException("Unsorted dates should contain at least 1 item.");
        }

        ArrayList<LocalDate> sorted = new ArrayList<>();
        ArrayList<LocalDate> withR = new ArrayList<>();
        ArrayList<LocalDate> noR = new ArrayList<>();

        for(var date : unsortedDates){
            /* if the month has r in the name, add this date to this list */
            if (hasR.get(date.getMonth())){
                withR.add(date);
            }
            /* otherwise add to noR list */
            else{
                noR.add(date);
            }
        }

        /* Sorting according to the task */
        withR.sort(dateComparator);
        noR.sort(reverseDateComparator);

        /* Merge */
        sorted.addAll(withR);
        sorted.addAll(noR);

        return sorted;
    }

    private void initializeMap() {
        hasR.put(Month.JANUARY, true);
        hasR.put(Month.FEBRUARY, true);
        hasR.put(Month.MARCH, true);
        hasR.put(Month.APRIL, true);
        hasR.put(Month.MAY, false);
        hasR.put(Month.JUNE, false);
        hasR.put(Month.JULY, false);
        hasR.put(Month.AUGUST, false);
        hasR.put(Month.SEPTEMBER, true);
        hasR.put(Month.OCTOBER, true);
        hasR.put(Month.NOVEMBER, true);
    }
}
