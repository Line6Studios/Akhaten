package com.linesix.akhaten.common.blocks.ores;

import com.linesix.akhaten.Akhaten;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.Ores;
import com.linesix.akhaten.common.items.registries.Materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
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
		//GameRegistry.addSmelting(Materials.rutile_ore, new ItemStack(Materials.raw_titanium), 3); <-- Bad and Temporary soloution for smelting Rutile ore, KEEP DISABLED
		GameRegistry.addSmelting(Ores.rutile_ore.getItemDropped(Ores.rutile_ore.getDefaultState(), Akhaten.random, 0), new ItemStack(Materials.raw_titanium), 3);
		GameRegistry.addSmelting(Materials.raw_titanium, new ItemStack(Materials.titanium_ingot), 3);
	}

}
