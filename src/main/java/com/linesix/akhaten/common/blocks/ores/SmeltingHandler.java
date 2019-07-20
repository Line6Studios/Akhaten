package com.linesix.akhaten.common.blocks.ores;

import com.linesix.akhaten.common.blocks.registries.Ores;
import com.linesix.akhaten.common.items.registries.Materials;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingHandler {

	/* Smelting Recipy Handler/Registry
	 * Add Smelting recipes in the registerSmeltingRecipes()
	 * method.
	 * 
	 * Author: Felix Eckert
	 * */
	
	public static void registerSmeltingRecipes() {
		GameRegistry.addSmelting(Materials.silicate_clump, new ItemStack(Materials.silicate_ingot), 2);
	}

}
