package net.time.stop.var;

public class TickUtil {
    public static int getServerTick() {
        return serverTick;
    }

    public static void setServerTick(int serverTick) {
        TickUtil.serverTick = serverTick;
    }

    public static void countTick(){
        serverTick++;
        serverTick%=tickMaxCapacity;
    }

    public static boolean isSelectedTick(){
        return serverTick%tickSelectPeriod==0;
    }

    public static int tickMaxCapacity=100,tickSelectPeriod=50;

    public static int serverTick=0;
}
