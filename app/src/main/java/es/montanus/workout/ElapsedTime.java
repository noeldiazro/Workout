package es.montanus.workout;

class ElapsedTime implements Time, Incrementable {

    private int baseSeconds = 0;

    @Override
    public int getHours() {
        return baseSeconds / SECONDS_PER_HOUR;
    }

    @Override
    public int getMinutes() {
        return (baseSeconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    }

    @Override
    public int getSeconds() {
        return baseSeconds % SECONDS_PER_MINUTE;
    }

    @Override
    public void increment() {
        baseSeconds++;
    }
}
