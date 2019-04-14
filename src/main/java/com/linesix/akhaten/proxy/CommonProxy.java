package com.linesix.akhaten.proxy;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    protected void preInit(FMLPreInitializationEvent event) {

        System.out.println("Entering PreInit phase");

    }

    protected void postInit(FMLPostInitializationEvent event) {

        System.out.println("Entering PostInit phase");

    }

}
