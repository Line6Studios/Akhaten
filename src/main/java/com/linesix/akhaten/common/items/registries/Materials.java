package com.linesix.akhaten.common.items.registries;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.tabs.TabMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import com.linesix.akhaten.common.items.materials.ElectronicCircut;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Materials {

    /*
     * Registration Handler of all Material-Items
     *
     * Author: Felix Eckert (TheBertrahmPlays / Angry German)
     *
     */

    public static final Set<Item> ITEMS = new HashSet<>();

    public static CreativeTabs materialtab = new TabMaterials();

    public static Item[] items;

    //Create all Gadget-Item vars below
    public static ElectronicCircut electronic_circuit;
    //End creation of Gadget-Item vars

    public static void init() {

        // Initialization of Gadget-Item-Variables below
        electronic_circuit = new ElectronicCircut();
        // End Initialization of Gadget-Item-Variables

    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {

        final IForgeRegistry<Item> registry = event.getRegistry(); // Put the registry in a variable

        items = new Item[] { // List all Items in here
                electronic_circuit
        };

        for (final Item item : items) {

            registry.register(item); // Register current item
            ITEMS.add(item); // Add the current item to the set

        }

    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {

        for (final Item item : items) {

            registerRender(item);

        }

    }

    private static void registerRender(Item item) {

        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));

    }

}
