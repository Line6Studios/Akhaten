package com.linesix.akhaten.proxy;

import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.items.Gadgets;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    protected void preInit(FMLPreInitializationEvent event) {

        System.out.println("Entering PreInit phase");

        DimBlocks.init();
        Gadgets.init();

    }

    protected void postInit(FMLPostInitializationEvent event) {

        System.out.println("Entering PostInit phase");

    }

}
