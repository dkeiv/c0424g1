import java.time.LocalDate;

public class NextDayCalculator {
    private LocalDate date;

    public NextDayCalculator(int day, int month, int year) {
        this.date = LocalDate.of(year, month, day);
    }

    public NextDayCalculator nextDay() {
        this.date = this.date.plusDays(1);
        return this;
    }

    @Override
    public String toString() {
        return "date=" + date;
    }
}
