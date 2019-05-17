package com.linesix.akhaten.common.blocks;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.common.blocks.machines.MachineTardis;
import com.linesix.akhaten.common.blocks.machines.tardisblocks.Handbrake;
import com.linesix.akhaten.tabs.TabMachines;
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
import com.linesix.akhaten.Reference;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class MachineBlocks {

   /* Registration of all Machine Blocks
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */

    public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>(); // Create a set for all item blocks

    public static CreativeTabs machineblocktab = new TabMachines(); // Create new instance of class TabMachines which is a Creative tab;

    public static Block[] blocks; // Create a new array for all blocks

    // Creation of all Block-Variables below
    public static MachineTardis machine_tardis;
    public static Handbrake tardis_handbrake;
    // End Creation of all Block-Variables

    public static void init() {

        System.out.println("Initializing machine-block-variables...");

        // Initialization of Block-Variables below
        try {

            machine_tardis = new MachineTardis();
            tardis_handbrake = new Handbrake();

        } catch (Exception e) {

            throw e;

        } finally { // When everything is done, execute the code below

            System.out.println("DONE!");

        }
        // End Initialization of Block-Variables

        // Write all block-variables to the blocks array

        System.out.println("Adding machine-block-variables to blocks array...");

        try {

            blocks = new Block[] {

                    machine_tardis,
                    tardis_handbrake

            };

        } catch (Exception e) {

            throw e;

        } finally { // When everything is done, execute the code below

            System.out.println("DONE!");

        }

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

                new ItemBlock(machine_tardis),
                new ItemBlock(tardis_handbrake)

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
