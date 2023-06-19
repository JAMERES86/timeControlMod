package ytse.jam.nomacium.production.tasks;


import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import ytse.jam.nomacium.ExampleMod;


/**
 * This is an example implementation of PlayerAnimator resourceLoading and playerMapping
 */
@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerAnimatorExample {


    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        //Set the player construct callback. It can be a lambda function.
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(
                new ResourceLocation(ExampleMod.MODID, "animation"),
                42,
                PlayerAnimatorExample::registerPlayerAnimation);
    }

    //This method will set your mods animation into the library.
    private static IAnimation registerPlayerAnimation(AbstractClientPlayer player) {
        //This will be invoked for every new player
        return new ModifierLayer<>();
    }

}
