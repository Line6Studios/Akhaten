package com.linesix.akhaten.common.blocks.registries;

import com.google.common.base.Preconditions;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.building.tardis.RoundelBase;
import com.linesix.akhaten.common.blocks.building.tardis.coral.CoralWall;
import com.linesix.akhaten.common.blocks.building.tardis.coral.CoralWire;
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
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
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
    public static RoundelBase block_roundel;
    public static CoralWire block_coralwire;
    public static CoralWall block_coralwall;
    public static RoundelBase block_coralroundel_a;
    public static RoundelBase block_coralroundel_b;
    public static RoundelBase block_coralroundel_c;
    public static Door block_door;
    // End Creation of all Block-Variables

    public static void init() {
        // Initialization of Block-Variables below
        block_roundel = new RoundelBase(Names.Machines.Tardis.Hartnell.hartnell_roundels);
        block_coralwire = new CoralWire();
        block_coralwall = new CoralWall();
        block_coralroundel_a = new RoundelBase(Names.Machines.Tardis.Coral.coral_roundel_a);
        block_coralroundel_b = new RoundelBase(Names.Machines.Tardis.Coral.coral_roundel_b);
        block_coralroundel_c = new RoundelBase(Names.Machines.Tardis.Coral.coral_roundel_c);
        block_door = new Door();
        // End Initialization of Block-Variables
    }

    @SubscribeEvent
    public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry(); // Put the registry in a variable

        blocks = new Block[] { // Add all block vars in this array
                block_roundel,
                block_coralwire,
                block_coralwall,
                block_coralroundel_a,
                block_coralroundel_b,
                block_coralroundel_c,
                block_door
        };

        registry.registerAll(blocks); // Register all blocks at once
    }

    @SubscribeEvent
    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        final ItemBlock[] items = { // Put the registry in a variable
                new ItemBlock(block_roundel),
                new ItemBlock(block_coralwire),
                new ItemBlock(block_coralwall),
                new ItemBlock(block_coralroundel_a),
                new ItemBlock(block_coralroundel_b),
                new ItemBlock(block_coralroundel_c),
                new ItemBlock(block_door)
        };

        for (final ItemBlock item : items) {
            final Block block = item.getBlock(); // Get the ItemBlock
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(),
                    "Block %s has a null registry name", block); // Get the registry name of the block (if it's not null)
            registry.register(item.setRegistryName(registryName)); // Set the registry name to content of variable "registryName"

            ITEM_BLOCKS.add(item); // Finally add the item to The ITEM_BLOCKS set
        }
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        OBJLoader.INSTANCE.addDomain(Reference.MODID);

        for (final Block block : blocks) {
            registerRender(Item.getItemFromBlock(block));
        }
    }

    public static void registerRender(Item item) {

        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }

    @Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
    public final class ClientEventSubscriber {

        @SubscribeEvent
        public void onRegisterModelsEvent(@Nonnull final ModelRegistryEvent event) {

            //ClientRegistry.bindTileEntitySpecialRenderer(TileEntity);
            ForgeRegistries.ITEMS.getValues().stream()
                    .filter(item -> item.getRegistryName().getResourceDomain().equals(Reference.MODID))
                    .forEach(item -> {ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));});

        }

    }

}
