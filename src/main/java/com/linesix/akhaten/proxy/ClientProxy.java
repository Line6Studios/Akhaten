package com.linesix.akhaten.proxy;

import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.items.Gadgets;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        DimBlocks.init();
        Gadgets.init();

        super.preInit(event);

    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

        super.postInit(event);

    }


}
