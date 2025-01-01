package net.kyryllkotyk.nuggetium;

import com.mojang.logging.LogUtils;
import net.kyryllkotyk.nuggetium.block.ModBlocks;
import net.kyryllkotyk.nuggetium.item.CreativeModeTabNugget;
import net.kyryllkotyk.nuggetium.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NuggetiumOre.MOD_ID)
public class NuggetiumOre
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "nuggetium";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public NuggetiumOre(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        CreativeModeTabNugget.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(NuggetPiece.NUGGET); //Texture done, add properties
//        }
//        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
//            event.accept(NuggetPiece.NUGGET_COOKED); //Texture done, add properties
//            event.accept(NuggetPiece.ENCHANTED_NUGGET); //Need texture and properties
//        }
//        if(event.getTabKey() == CreativeModeTabs.COMBAT){
//            event.accept(NuggetPiece.NUGSCALIBUR); //Need texture and properties
//            event.accept(NuggetPiece.MEOWMERE);//Need texture and properties
//            event.accept(NuggetPiece.CATACLYSM);//Need texture and properties
//            event.accept(NuggetPiece.NFC_BUCKET);//Need texture and properties
//            event.accept(NuggetPiece.DEEP_FRIED_CHESTPLATE);//Need texture and properties
//            event.accept(NuggetPiece.DRUMSTICK_TROUSERS);//Need texture and properties
//            event.accept(NuggetPiece.CRISPY_FLIP_FLOPS);//Need texture and properties
//            event.accept(NuggetPiece.NUGGET_CROWN);//Need texture and properties
//            event.accept(NuggetPiece.NUGGET_CORSET);//Need texture and properties
//            event.accept(NuggetPiece.NUGGET_GREAVES);//Need texture and properties
//            event.accept(NuggetPiece.NUGGET_HEELS);//Need texture and properties
//        }
//        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
//            event.accept(NuggetPiece.STARCAT_PICKAXE);//Need texture and properties
//            event.accept(NuggetPiece.TERRACLAW);//Need texture and properties
//            event.accept(NuggetPiece.CLAWTIVATOR);//Need texture and properties
//        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
