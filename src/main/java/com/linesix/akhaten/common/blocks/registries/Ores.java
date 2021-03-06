package com.linesix.akhaten.common.blocks.registries;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.ores.RutileOre;
import com.linesix.akhaten.common.blocks.ores.SiliconOre;
import com.linesix.akhaten.tabs.TabDim;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Ores {

   /* Registration of all Ores
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */

	public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>(); // Create a set for all item blocks
	
    public static Block[] blocks; // Create a new array for all blocks

    // Creation of all Block-Variables below
    public static SiliconOre silicon_ore;
    public static RutileOre rutile_ore;
    // End Creation of all Block-Variables

    public static void init() { 
    	// Initialization of Block-Variables below
        silicon_ore = new SiliconOre();
        rutile_ore = new RutileOre();
        // End Initialization of Block-Variables

        // Write all block-variables to the blocks array
        blocks = new Block[] {
        		silicon_ore,
        		rutile_ore
        };
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {

        IForgeRegistry<Block> registry = event.getRegistry();

        registry.registerAll(blocks); // Reigster all blocks at once

    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {

        final IForgeRegistry<Item> registry = event.getRegistry();

        final ItemBlock[] items = {
        		new ItemBlock(silicon_ore),
        		new ItemBlock(rutile_ore)
        };

        for (final ItemBlock item : items) {

            final Block block = item.getBlock(); // Get the ItemBlock

            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(),
                    "Block %s gas null registry name", block); // Get the registry name of the block (if it's not null)
            registry.register(item.setRegistryName(registryName)); // Set the registry name to content of variable
            // "registryName"

            ITEM_BLOCKS.add(item); // Finally add the item to The ITEM_BLOCKS set

        }

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        OBJLoader.INSTANCE.addDomain(Reference.MODID);

        for (final Block block : blocks) {
            registerRender(block, 0);
        }


    }

    public static void registerRender(Block block, int meta) {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                new ModelResourceLocation(Item.getItemFromBlock(block).getRegistryName(), "inventory"));

    }

}
