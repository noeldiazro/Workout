package es.montanus.workout;

import java.util.Locale;

class StopwatchTimeFormatter {
    public String format(Time time) {
        return String.format(Locale.getDefault(),
                "%d:%02d:%02d",
                time.getHours(),
                time.getMinutes(),
                time.getSeconds());
    }
}
