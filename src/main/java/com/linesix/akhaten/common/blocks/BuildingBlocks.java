package com.linesix.akhaten.common.blocks;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.Reference;
import com.linesix.akhaten.common.blocks.building.HartnellRoundel;
import com.linesix.akhaten.common.blocks.building.Door;
import com.linesix.akhaten.tabs.TabBuilding;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class BuildingBlocks {

    /*
     * Registration Handler of all Building Blocks
     *
     * Author: Felix Eckert (TheBertrahmPlays / Angry German)
     *
     */

    public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>(); // Create a set for all item blocks

    public static CreativeTabs buildblocktab = new TabBuilding();

    private static Block[] blocks; // Create an array for all blocks

    // Creation of all Block-Variables below
    public static HartnellRoundel block_roundel;
    public static Door block_door;
    // End Creation of all Block-Variables

    public static void init() {

        System.out.println("Initializing building-block-variables...");

        // Initialization of Block-Variables below
        try {

            block_roundel = new HartnellRoundel();
            block_door = new Door();

        } catch (Exception e) { // If theres an error whilst initializing any of the Variables, execute the code below

            throw e;

        } finally { // When everything is done, execute the code below

            System.out.println("DONE!");

        }

        // End Initialization of Block-Variables

    }

    @SubscribeEvent
    public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {

        final IForgeRegistry<Block> registry = event.getRegistry(); // Put the registry in a variable

        blocks = new Block[] { // Add all block vars in this array

                block_roundel,
                block_door

        };

        registry.registerAll(blocks); // Register all blocks at once

    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {

        final IForgeRegistry<Item> registry = event.getRegistry();

        final ItemBlock[] items = { // Put the registry in a variable

                new ItemBlock(block_roundel),
                new ItemBlock(block_door)

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

        for (final Block block : blocks) {

            registerRender(Item.getItemFromBlock(block));

        }

    }

    public static void registerRender(Item item) {

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }

}
