package com.linesix.akhaten;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Akhaten {



   /*
    * Akhaten Public Beta (Version 0.4.0)
    * Copyright (C) 2019 Linesix Studios, Licensed under the ISC license
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */



    private static Logger logger; //Create a new logger

    public static Random random = new Random();

    @Mod.Instance(Reference.MODID)
    public static Akhaten instance; // Create an instance of the main class

    @SidedProxy(clientSide = "com.linesix.akhaten.proxy.ClientProxy", serverSide = "com.linesix.akahten.proxy.CommonProxy")
    public static CommonProxy proxy; // Create a CommonProxy

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        System.out.println("Entering PreInit phase");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        System.out.println("Entering Init phase");

    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        System.out.println("Entering PostInit phase");

    }


}
