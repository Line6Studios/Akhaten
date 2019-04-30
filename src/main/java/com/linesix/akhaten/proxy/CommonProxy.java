package com.linesix.akhaten.proxy;

import com.linesix.akhaten.blocks.BuildingBlocks;
import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.dimensions.Dimensions;
import com.linesix.akhaten.items.Gadgets;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    protected void preInit(FMLPreInitializationEvent event) {

        System.out.println("Entering PreInit phase");

        DimBlocks.init();
        MachineBlocks.init();
        BuildingBlocks.init();
        Gadgets.init();

    }

    protected void init(FMLInitializationEvent event) {

        System.out.println("Entering PreInit phase");

        Dimensions.registerDimensions();

    }

    protected void postInit(FMLPostInitializationEvent event) {

        System.out.println("Entering PostInit phase");

    }

}
