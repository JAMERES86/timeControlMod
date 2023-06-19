package net.time.stop.var;
public class DebugSampleUtil {
    public static void msgSample(String input){
        if(TickUtil.isSelectedTick()) System.out.println(input);
    }
    public static void msgSample(){
        if(TickUtil.isSelectedTick()) System.out.println();
    }
}
