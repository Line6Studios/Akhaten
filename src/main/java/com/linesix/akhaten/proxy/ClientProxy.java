package com.linesix.akhaten.proxy;

import com.linesix.akhaten.common.blocks.BuildingBlocks;
import com.linesix.akhaten.common.blocks.DimBlocks;
import com.linesix.akhaten.common.blocks.MachineBlocks;
import com.linesix.akhaten.common.dimensions.Dimensions;
import com.linesix.akhaten.common.items.Gadgets;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        DimBlocks.init();
        MachineBlocks.init();
        BuildingBlocks.init();
        Gadgets.init();

        super.preInit(event);

    }

    public void init(FMLInitializationEvent event) {

        Dimensions.registerDimensions();

        super.init(event);

    }

    public void postInit(FMLPostInitializationEvent event) {

        super.postInit(event);

    }


}
