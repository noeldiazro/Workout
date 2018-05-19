package es.montanus.workout;

class StopwatchPresenter implements ClockListener {

    private final StopwatchFragment fragment;
    private final ElapsedTime time = new ElapsedTime();
    private final StopwatchTimeFormatter formatter = new StopwatchTimeFormatter();

    StopwatchPresenter(StopwatchFragment fragment) {
        this.fragment = fragment;
        init();
    }

    private void init() {
        setTime();
    }

    private void setTime() {
        fragment.setTime(formatter.format(time));
    }

    public void start() {
        fragment.display("Started!");
        Clock clock = new Clock(this);
        clock.start();
    }

    @Override
    public void onTick() {
        time.increment();
        setTime();
    }
}
