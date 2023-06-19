package ytse.jam.nomacium.core.util;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class timerTask {
    Runnable runnable;
    int delayTick;
    IEventBus bus;

    /***
     * @param bus 事件总线
     * @param runnable 要执行的内容
     * @param delayTick 延时的时间
     */
    public timerTask(IEventBus bus, Runnable runnable, int delayTick) {
        this.runnable = runnable;
        this.delayTick = delayTick;

        this.bus = bus;

        bus.register(this);
    }

    public timerTask(Runnable runnable, int delayTick) {
        this(MinecraftForge.EVENT_BUS, runnable, delayTick);
    }

    @SubscribeEvent
    public void tick(TickEvent event) {
        System.out.println("TIMER LEFT: "+delayTick);
        if (delayTick-- <= 0) {
            runnable.run();
            bus.unregister(this);
        }
    }
}
