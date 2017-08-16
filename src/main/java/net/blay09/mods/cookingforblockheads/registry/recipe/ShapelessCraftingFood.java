package net.blay09.mods.cookingforblockheads.registry.recipe;

import com.google.common.collect.Lists;
import net.blay09.mods.cookingforblockheads.registry.CookingRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

public class ShapelessCraftingFood extends FoodRecipe {

    public ShapelessCraftingFood(ShapelessRecipes recipe) {
        this.outputItem = recipe.getRecipeOutput();
        this.craftMatrix = Lists.newArrayList();
        for(int i = 0; i < recipe.recipeItems.size(); i++) {
            ItemStack itemStack = recipe.recipeItems.get(i);
            if (itemStack != null && !itemStack.isEmpty()) {
                boolean isToolItem = CookingRegistry.isToolItem(recipe.recipeItems.get(i));
                craftMatrix.add(new FoodIngredient(recipe.recipeItems.get(i).copy(), isToolItem));
            }
        }
    }

}