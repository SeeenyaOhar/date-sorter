import org.datesorter.DateComparator;
import org.datesorter.DefaultDateSorter;
import org.datesorter.ReverseDateComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultDateSorterTest {
    private final DefaultDateSorter sorter = new DefaultDateSorter();
    private final DateComparator comparator = new DateComparator();
    private final ReverseDateComparator reverseComparator = new ReverseDateComparator();

    /**
     * This test has been made from
     * the IDateSorter interface's description
     */
    @Test
    public void exampleTest(){
        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2005, 7, 1));
        dates.add(LocalDate.of(2005, 1, 2));
        dates.add(LocalDate.of(2005, 1, 1));
        dates.add(LocalDate.of(2005, 5, 3));

        var sorted = sorter.sortDates(dates);
        ArrayList<LocalDate> expected = new ArrayList<>(List.of(dates.get(2),
                dates.get(1),
                dates.get(0),
                dates.get(3)));

        System.out.println(sorted);
        Assertions.assertEquals(sorted, expected);
    }

    @Test
    public void everyMonthWithR(){
        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2005, 1, 4)); // januaRy
        dates.add(LocalDate.of(2005, 1, 3));
        dates.add(LocalDate.of(2005, 1, 2));
        dates.add(LocalDate.of(2005, 1, 1));

        var sorted = sorter.sortDates(dates);
        List<LocalDate> expected = new ArrayList<>(List.copyOf(dates));
        expected.sort(comparator);

        System.out.println(sorted);
        Assertions.assertEquals(sorted, expected);
    }

    @Test
    public void everyMonthNoR(){
        ArrayList<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2005, 6, 1));
        dates.add(LocalDate.of(2005, 6, 2));
        dates.add(LocalDate.of(2005, 6, 3));
        dates.add(LocalDate.of(2005, 6, 4));

        var sorted = sorter.sortDates(dates);
        List<LocalDate> expected = new ArrayList<>(List.copyOf(dates));
        expected.sort(reverseComparator);

        System.out.println(sorted);
        Assertions.assertEquals(sorted, expected);
    }
}
