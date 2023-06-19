package net.time.stop.var;

public class TimeStopUtil {
    public static boolean isTimeStopped() {
        return timeStopped;
    }

    public static void setTimeStopped(boolean timeStopped) {
        TimeStopUtil.timeStopped = timeStopped;
    }

    public static void changeTimeStopped() {
        System.out.println("Changed Time Stop Status");
        TimeStopUtil.timeStopped = !timeStopped;
    }

    public static boolean timeStopped=false;
}
