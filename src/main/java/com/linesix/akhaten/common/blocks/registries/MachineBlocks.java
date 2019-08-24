package com.linesix.akhaten.common.blocks.registries;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.common.blocks.machines.tardis.MachineTardis;
import com.linesix.akhaten.common.blocks.machines.tardis.Handbrake;
import com.linesix.akhaten.common.blocks.machines.tardis.TardisMonitor;
import com.linesix.akhaten.common.blocks.machines.tardis.tardiscore.*;
import com.linesix.akhaten.tabs.TabMachines;
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
import com.linesix.akhaten.common.Reference;
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
    public static TardisMonitor tardis_monitor;
    public static TardisCore tardis_core;
    public static CoreBeam core_beam;
    public static CoreFrame core_frame;
    public static CoreConnector core_connector;
    public static ConsoleInterface console_interface;
    // End Creation of all Block-Variables

    public static void init() {
        Reference.logger.info("Initializing machine-block-variables...");

        // Initialization of Block-Variables below
         machine_tardis = new MachineTardis();
        tardis_handbrake = new Handbrake();
        tardis_monitor = new TardisMonitor();
        Reference.logger.info("DONE!");
        // End Initialization of Block-Variables

        blocks = new Block[] {
                machine_tardis,
                tardis_handbrake,
                tardis_monitor,
                tardis_core,
                console_interface,
                core_beam,
                core_connector,
                core_frame
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
                new ItemBlock(machine_tardis),
                new ItemBlock(tardis_handbrake),
                new ItemBlock(tardis_monitor),
                new ItemBlock(tardis_core),
                new ItemBlock(console_interface),
                new ItemBlock(core_beam),
                new ItemBlock(core_connector),
                new ItemBlock(core_frame)
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
