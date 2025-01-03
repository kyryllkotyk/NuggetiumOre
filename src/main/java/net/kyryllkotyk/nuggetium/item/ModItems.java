package net.kyryllkotyk.nuggetium.item;

import net.kyryllkotyk.nuggetium.NuggetiumOre;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NuggetiumOre.MOD_ID);

    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_COOKED = ITEMS.register("nugget_cooked", () -> new Item(new Item.Properties().food(ModFoods.NUGGET_COOKED)));
//    public static final RegistryObject<Item>  ENCHANTED_NUGGET = ITEMS.register("enchantedNugget",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NUGSCALIBUR = ITEMS.register("nugscalibur",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> MEOWMERE = ITEMS.register("meowmere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> STARCAT_PICKAXE = ITEMS.register("starCatPickaxe",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item>  PAWERFUL_AXE = ITEMS.register("pawerfulAxe",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> TERRACLAW = ITEMS.register("terraclaw",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> CLAWTIVATOR = ITEMS.register("clawtivator",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> CATACLYSM = ITEMS.register("cataclysm",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NFC_BUCKET = ITEMS.register("nfcBucket",
//            () -> new ArmorItem(NUGGET, ArmorItem.Type.HELMET, ))
//    public static final RegistryObject<Item> DEEP_FRIED_CHESTPLATE = ITEMS.register("deepFriedChestplate",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> DRUMSTICK_TROUSERS = ITEMS.register("drumstickTrousers",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> CRISPY_FLIP_FLOPS = ITEMS.register("crispyFlipFlops",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NUGGET_CROWN = ITEMS.register("nuggetCrown",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NUGGET_CORSET = ITEMS.register("nuggetCorset",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NUGGET_GREAVES = ITEMS.register("nuggetGreaves",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> NUGGET_HEELS = ITEMS.register("nuggetHeels",
//            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
