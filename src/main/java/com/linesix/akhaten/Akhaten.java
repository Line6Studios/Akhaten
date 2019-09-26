package com.linesix.akhaten;

import com.linesix.akhaten.common.blocks.ores.SmeltingHandler;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import com.linesix.akhaten.common.blocks.registries.DimBlocks;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.blocks.registries.Ores;
import com.linesix.akhaten.common.items.registries.Materials;
import com.linesix.akhaten.server.commands.Commands;
import com.linesix.akhaten.common.dimensions.Dimensions;
import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.proxy.CommonProxy;
import com.linesix.akhaten.common.sound.SoundRegistry;
import com.linesix.akhaten.common.worldgen.OreGen;
import com.linesix.akhaten.common.Reference;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Akhaten {
   /*
    * Akhaten Public Beta (Version 0.6.1)
    * Copyright (C) 2019 Linesix Studios, Licensed under the ISC license
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */

    public static Random random = new Random();

    @Mod.Instance(Reference.MODID)
    public static Akhaten instance; // Create an instance of the main class

    @SidedProxy(clientSide = "com.linesix.akhaten.proxy.ClientProxy", serverSide = "com.linesix.akahten.proxy.CommonProxy")
    public static CommonProxy proxy; // Create a CommonProxy

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Reference.logger.info("Entering PreInit phase...");

        // Register Items Blocks and Sounds Below
        SoundRegistry.init();
        DimBlocks.init();
        MachineBlocks.init();
        BuildingBlocks.init();
        Gadgets.init();
        Materials.init();
        Ores.init();
        Reference.logger.info("(VERSION) Client is using Akhaten version: "+Reference.VERSION);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Reference.logger.info("Entering Init phase...");

        // Register Dimensions below
        Dimensions.registerDimensions();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);

        // Other registries
        SmeltingHandler.registerSmeltingRecipes(); // Register all Smelting recipes
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) { // This method just exists for registering commands
        // Register Commands Below
        Commands.register(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Reference.logger.info("Entering PostInit phase...");
        System.out.println("Fantastic! You are playing with Akhaten, thank you!");
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        event.player.sendMessage(new TextComponentString("§6You are playing with Akhaten §3"+Reference.VERSION));
    }
}
