package net.kyryllkotyk.nuggetium.item;

import net.kyryllkotyk.nuggetium.NuggetiumOre;
import net.kyryllkotyk.nuggetium.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabNugget {
    public static final DeferredRegister<CreativeModeTab>  CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuggetiumOre.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUGGET_TAB = CREATIVE_MODE_TABS.register("nugget_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .title(Component.translatable("creativetab.nugget_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.NUGGET.get());
                        pOutput.accept(ModItems.NUGGET_COOKED.get());
                        pOutput.accept(ModBlocks.NUGGET_ORE.get());
                        pOutput.accept(ModBlocks.NUGGET_BLOCK.get());
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
