package com.linesix.akhaten.proxy;

import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import com.linesix.akhaten.common.blocks.registries.DimBlocks;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.dimensions.Dimensions;
import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.common.items.registries.Materials;
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
        Materials.init();

    }

    protected void init(FMLInitializationEvent event) {

        System.out.println("Entering PreInit phase");

        Dimensions.registerDimensions();

    }

    protected void postInit(FMLPostInitializationEvent event) {

        System.out.println("Entering PostInit phase");

    }

}
