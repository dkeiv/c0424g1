import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextDayCalculatorTest {

    @Test
    public void theFirstOfJanuary() {
        int day = 1;
        int month = 1;
        int year = 2018;
        String expected = "date=2018-01-02";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void thirtyFirstOfJanuary() {
        int day = 31;
        int month = 1;
        int year = 2018;
        String expected = "date=2018-02-01";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void thirtyOfApril() {
        int day = 30;
        int month = 4;
        int year = 2018;
        String expected = "date=2018-05-01";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void twentyEightOfFebruary() {
        int day = 28;
        int month = 2;
        int year = 2018;

        String expected = "date=2018-03-01";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void twentyNineOfFebruary() {
        int day = 29;
        int month = 2;
        int year = 2020;
        String expected = "date=2020-03-01";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }

    @Test
    public void thirtyFirstOfDecember() {
        int day = 31;
        int month = 12;
        int year = 2018;
        String expected = "date=2019-01-01";

        NextDayCalculator calculator = new NextDayCalculator(day, month, year);
        String actual = calculator.nextDay().toString();

        assertEquals(expected, actual);
    }
}
