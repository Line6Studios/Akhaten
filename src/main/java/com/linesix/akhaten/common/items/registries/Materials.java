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

import com.linesix.akhaten.common.items.materials.AerotronicCapacitor;
import com.linesix.akhaten.common.items.materials.AerotronicCircuit;
import com.linesix.akhaten.common.items.materials.AerotronicCore;
import com.linesix.akhaten.common.items.materials.ArtronCapacitor;
import com.linesix.akhaten.common.items.materials.ElectronicCircut;
import com.linesix.akhaten.common.items.materials.RawTitanium;
import com.linesix.akhaten.common.items.materials.RutileOre;
import com.linesix.akhaten.common.items.materials.SilicateClump;
import com.linesix.akhaten.common.items.materials.SilicateIngot;
import com.linesix.akhaten.common.items.materials.TitaniumIngot;

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
    public static SilicateIngot silicate_ingot;
    public static SilicateClump silicate_clump;
    public static AerotronicCapacitor aerotronic_capacitor;
    public static AerotronicCircuit aerotronic_circuit;
    public static AerotronicCore aerotronic_core;
    public static ArtronCapacitor artron_capacitor;
    public static RawTitanium raw_titanium;
    public static TitaniumIngot titanium_ingot;
    public static RutileOre rutile_ore;
    //End creation of Gadget-Item vars

    public static void init() {
        // Initialization of Gadget-Item-Variables below
        electronic_circuit = new ElectronicCircut();
        silicate_ingot = new SilicateIngot();
        silicate_clump = new SilicateClump();
        aerotronic_circuit = new AerotronicCircuit();
        aerotronic_core = new AerotronicCore();
        aerotronic_capacitor = new AerotronicCapacitor();
        artron_capacitor = new ArtronCapacitor();
        raw_titanium = new RawTitanium();
        titanium_ingot = new TitaniumIngot();
        rutile_ore = new RutileOre();
        // End Initialization of Gadget-Item-Variables
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry(); // Put the registry in a variable

        items = new Item[] { // List all Items in here
                electronic_circuit,
                silicate_ingot,
                silicate_clump,
                aerotronic_capacitor,
                aerotronic_core,
                aerotronic_circuit,
                artron_capacitor,
                raw_titanium,
                titanium_ingot,
                rutile_ore
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
