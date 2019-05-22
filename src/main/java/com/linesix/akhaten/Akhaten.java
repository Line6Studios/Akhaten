package com.linesix.akhaten;

import com.linesix.akhaten.common.blocks.BuildingBlocks;
import com.linesix.akhaten.common.blocks.DimBlocks;
import com.linesix.akhaten.common.blocks.MachineBlocks;
import com.linesix.akhaten.server.commands.Commands;
import com.linesix.akhaten.common.dimensions.Dimensions;
import com.linesix.akhaten.common.items.Gadgets;
import com.linesix.akhaten.proxy.CommonProxy;
import com.linesix.akhaten.common.sound.SoundRegistry;
import com.linesix.akhaten.common.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.util.Random;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Akhaten {



   /*
    * Akhaten Public Beta (Version 0.3.91)
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

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        Reference.logger.info("Entering Init phase...");

        // Register Dimensions below
        Dimensions.registerDimensions();

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) { // This method just exists for registering commands

        // Register Commands Below
        Commands.register(event);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Reference.logger.info("Entering PostInit phase...");

    }

}
