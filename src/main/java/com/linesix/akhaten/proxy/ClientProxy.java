package com.linesix.akhaten.proxy;

import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.dimensions.Dimensions;
import com.linesix.akhaten.items.Gadgets;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        DimBlocks.init();
        MachineBlocks.init();
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
