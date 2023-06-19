package net.time.stop.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import net.time.stop.var.DebugSampleUtil;
import net.time.stop.var.TickUtil;
import net.time.stop.var.TimeStopUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

@Mixin(ServerLevel.class)
public abstract class ServerTickingMixin extends Level{

    protected ServerTickingMixin(WritableLevelData p_220352_, ResourceKey<Level> p_220353_, Holder<DimensionType> p_220354_, Supplier<ProfilerFiller> p_220355_, boolean p_220356_, boolean p_220357_, long p_220358_, int p_220359_) {
        super(p_220352_, p_220353_, p_220354_, p_220355_, p_220356_, p_220357_, p_220358_, p_220359_);
    }

    /**
     * @author James
     * @reason Disable tick for time stopped entities
     */
    @Overwrite
    public void tickNonPassenger(Entity tickedEntity) {
        tickedEntity.setOldPosAndRot();
        ProfilerFiller profilerfiller = this.getProfiler();
        ++tickedEntity.tickCount;
        this.getProfiler().push(() -> {
            return BuiltInRegistries.ENTITY_TYPE.getKey(tickedEntity.getType()).toString();
        });
        profilerfiller.incrementCounter("tickNonPassenger");

        DebugSampleUtil.msgSample("(Server)Time stopped: "+TimeStopUtil.isTimeStopped());
        if((tickedEntity instanceof Player)||!TimeStopUtil.isTimeStopped()){
            tickedEntity.tick();
        }else{
            DebugSampleUtil.msgSample("Disabled Tick for entity: "+tickedEntity.getClass().getSimpleName());
        }
        this.getProfiler().pop();

        for(Entity entity : tickedEntity.getPassengers()) {
            this.tickPassenger(tickedEntity, entity);
        }

    }

    @Shadow
    protected abstract void tickPassenger(Entity p_8648_, Entity entity);

    @Inject(method="tick",at=@At("HEAD"))
    public void tick(BooleanSupplier p_8794_, CallbackInfo ci) {
        TickUtil.countTick();
    }
}
