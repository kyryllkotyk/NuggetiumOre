package net.kyryllkotyk.nuggetium.datagen;

import net.kyryllkotyk.nuggetium.NuggetiumOre;
import net.kyryllkotyk.nuggetium.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NuggetiumOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.NUGGET_BLOCK.get(), ModBlocks.NUGGET_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.NUGGET_BLOCK.get(), ModBlocks.NUGGET_ORE.get());
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
    }
}