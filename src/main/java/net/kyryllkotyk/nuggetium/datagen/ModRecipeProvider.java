package net.kyryllkotyk.nuggetium.datagen;

import net.kyryllkotyk.nuggetium.NuggetiumOre;
import net.kyryllkotyk.nuggetium.block.ModBlocks;
import net.kyryllkotyk.nuggetium.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NUGGET_SMELTABLES = List.of(ModItems.NUGGET.get(),
            ModBlocks.NUGGET_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreSmelting(pRecipeOutput, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 1, 300, "nugget");
        oreBlasting(pRecipeOutput, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 1, 150, "nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NUGGET_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NUGGET.get(), 32)
                .requires(ModBlocks.NUGGET_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NUGGET_BLOCK.get()), has(ModBlocks.NUGGET_BLOCK.get()))
                .save(pRecipeOutput, NuggetiumOre.MOD_ID + ":nugget_from_nugget_block");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                       float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NuggetiumOre.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
