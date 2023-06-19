package net.time.stop.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.time.stop.var.DebugSampleUtil;
import net.time.stop.var.TimeStopUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TimeStopItem extends Item {
    public TimeStopItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {

            DebugSampleUtil.msgSample("(ItemS)(Server)Time stopped: "+TimeStopUtil.isTimeStopped());
            TimeStopUtil.changeTimeStopped();
            DebugSampleUtil.msgSample("(ItemE)(Server)Time stopped: "+TimeStopUtil.isTimeStopped());
        }
//        if(level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
//            TimeStopUtil.changeTimeStopped();
//        }

        player.getCooldowns().addCooldown(this, 3);

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to stop the time!").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, components, flag);
    }
}
