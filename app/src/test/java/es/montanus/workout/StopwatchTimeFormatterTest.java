package es.montanus.workout;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StopwatchTimeFormatterTest {

    private StopwatchTimeFormatter formatter;

    @Before
    public void setUp() throws Exception {
        formatter = new StopwatchTimeFormatter();
    }

    @Test
    public void formatZero() {
        assertFormat(0, 0, 0, "0:00:00");
    }

    @Test
    public void formatOneSecond() {
        assertFormat(0, 0, 1, "0:00:01");
    }

    @Test
    public void formatTenSeconds() {
        assertFormat(0, 0, 10,"0:00:10");
    }

    @Test
    public void formatOneMinute() {
        assertFormat(0, 1, 0,"0:01:00");
    }

    @Test
    public void formatTenMinutes() {
        assertFormat(0, 10, 0, "0:10:00");
    }

    @Test
    public void formatOneHour() {
        assertFormat(1, 0, 0, "1:00:00");
    }

    private void assertFormat(int hours, int minutes, int seconds, String expected) {
        Time time = new TimeStub(hours, minutes, seconds);
        assertEquals(expected, formatter.format(time));
    }

    private class TimeStub implements Time {
        private final int hours;
        private final int minutes;
        private final int seconds;

        TimeStub(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        @Override
        public int getHours() {
            return hours;
        }

        @Override
        public int getMinutes() {
            return minutes;
        }

        @Override
        public int getSeconds() {
            return seconds;
        }
    }
}
