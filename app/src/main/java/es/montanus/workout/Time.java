package es.montanus.workout;

interface Time {
    int SECONDS_PER_MINUTE = 60;
    int SECONDS_PER_HOUR = 3600;

    int getHours();
    int getMinutes();
    int getSeconds();
}
