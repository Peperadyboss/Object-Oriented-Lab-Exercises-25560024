public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23.");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59.");
        }

        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59.");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }

    public void addSeconds(int seconds) {
        int totalSeconds = hour * 3600 + minute * 60 + second;

        totalSeconds = (totalSeconds + seconds) % 86400;

        if (totalSeconds < 0) {
            totalSeconds += 86400;
        }

        hour = totalSeconds / 3600;
        totalSeconds %= 3600;

        minute = totalSeconds / 60;
        second = totalSeconds % 60;
    }

    public void subtractSeconds(int seconds) {
        addSeconds(-seconds);
    }
}