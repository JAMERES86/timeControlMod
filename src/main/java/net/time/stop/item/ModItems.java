package net.time.stop.item;

import net.time.stop.TutorialMod;
import net.time.stop.block.ModBlocks;
import net.time.stop.entity.ModEntityTypes;
import net.time.stop.fluid.ModFluids;
import net.time.stop.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.time.stop.item.custom.TimeStopItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TIME_STOP = ITEMS.register("time_stop",
            () -> new TimeStopItem(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> KAUPENSWORD = ITEMS.register("kaupensword",
            () -> new SwordItem(Tiers.DIAMOND, 10, 5f,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("chomper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CHOMPER, 0x22b341, 0x19732e,
                    new Item.Properties()));

    public static final RegistryObject<Item> ZIRCON_PICKAXE = ITEMS.register("zircon_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ZIRCON, 2, 3f,
                    new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
