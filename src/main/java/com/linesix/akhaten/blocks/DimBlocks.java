package com.linesix.akhaten.blocks;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class DimBlocks {

    //TODO: Create Creative Tab for Dimensional blocks
    //TODO: Add in Dimensional blocks
    //TODO: Add in Dimensions

   /*
    * Registration Handler of all Dimensional Blocks
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */

    public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>(); // Create a set for all item blocks

    private static Block[] blocks; // Create an array for all blocks

    // Creation of all Block-Variables below
    // End Creation of all Block-Variables

    public static void init() {

        System.out.println("Initializing block-variables...");

        //Initialization of Block-Variables below
        try {



        } catch (Exception e) {

            throw e;

        } finally {

            System.out.println("DONE!");

        }

        //End Initialization of Block-Variables

    }

    @SubscribeEvent
    public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {

        final IForgeRegistry<Block> registry = event.getRegistry(); // Put the registry in a variable

        blocks = new Block[] { // Add all block vars in this array



        };

        registry.registerAll(blocks); // Reigster all blocks at once

    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {

        final IForgeRegistry<Item> registry = event.getRegistry();

        final ItemBlock[] items = { // Put the registry in a variable



        };

        for (final ItemBlock item : items) {

            final Block block = item.getBlock(); // Get the ItemBlock

            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s gas null registry name", block); // Get the registry name of the block (if it's not null)
            registry.register(item.setRegistryName(registryName)); // Set the registry name to content of variable "registryName"

            ITEM_BLOCKS.add(item); // Finally add the item to The ITEM_BLOCKS set

        }

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        for (final Block block : blocks) {

            registerRender(Item.getItemFromBlock(block));

        }

    }

    public static void registerRender(Item item) {

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }

}
