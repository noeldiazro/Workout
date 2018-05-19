package es.montanus.workout;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ElapsedTimeTest {

    private ElapsedTime elapsedTime;
    private Incrementor incrementor;

    @Before
    public void setUp() throws Exception {
        elapsedTime = new ElapsedTime();
        incrementor = new Incrementor();
    }

    @Test
    public void createElapsedTime() {
        final int expectedHours = 0;
        final int expectedMinutes = 0;
        final int expectedSeconds = 0;
        assertTimeParts(expectedHours, expectedMinutes, expectedSeconds);
    }

    @Test
    public void incrementOnce() {
        incrementor.once();
        assertTimeParts(0, 0, 1);
    }

    @Test
    public void incrementTwice() {
        incrementor.twice();
        assertTimeParts(0, 0, 2);
    }

    @Test
    public void increment60Times() {
        incrementor.times(Time.SECONDS_PER_MINUTE);
        assertTimeParts(0, 1, 0);
    }

    @Test
    public void oneMinuteOneSecondElapsed() {
        incrementor.times(Time.SECONDS_PER_MINUTE + 1);
        assertTimeParts(0, 1, 1);
    }

    @Test
    public void twoMinutes() {
        incrementor.times(2 * Time.SECONDS_PER_MINUTE);
        assertTimeParts(0, 2, 0);
    }

    @Test
    public void oneSecondToAnHour() {
        incrementor.times(Time.SECONDS_PER_HOUR - 1);
        assertTimeParts(0, 59, 59);
    }

    @Test
    public void oneHour() {
        incrementor.times(Time.SECONDS_PER_HOUR);
        assertTimeParts(1,0,0);
    }

    @Test
    public void oneHourOneMinute() {
        incrementor.times(Time.SECONDS_PER_HOUR + 1);
        assertTimeParts(1, 0, 1);
    }

    @Test
    public void integration() {
        incrementor.times(5 * Time.SECONDS_PER_HOUR + 34 * Time.SECONDS_PER_MINUTE + 56);
        assertTimeParts(5, 34, 56);
    }

    private void assertTimeParts(int expectedHours, int expectedMinutes, int expectedSeconds) {
        assertEquals(expectedHours, elapsedTime.getHours());
        assertEquals(expectedMinutes, elapsedTime.getMinutes());
        assertEquals(expectedSeconds, elapsedTime.getSeconds());
    }

    private class Incrementor {

        void times(int target) {
            for (int i=0; i < target; i++)
                elapsedTime.increment();
        }

        void twice() {
            times(2);
        }

        void once() {
            times(1);
        }
    }
}
