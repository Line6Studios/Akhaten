package com.linesix.akhaten.proxy;

import com.linesix.akhaten.common.blocks.ores.SmeltingHandler;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import com.linesix.akhaten.common.blocks.registries.DimBlocks;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.blocks.registries.Ores;
import com.linesix.akhaten.common.dimensions.Dimensions;
import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.common.items.registries.Materials;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.linesix.akhaten.common.Reference.MODID;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(MODID);
        DimBlocks.init();
        Ores.init();
        MachineBlocks.init();
        BuildingBlocks.init();
        Gadgets.init();
        Materials.init();
        SmeltingHandler.registerSmeltingRecipes();
    }

    public void init(FMLInitializationEvent event) {

        Dimensions.registerDimensions();

        super.init(event);

    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        // For some reason I have to manually register sprites
        event.getMap().registerSprite(new ResourceLocation("akhaten:blocks/lightbox"));
        event.getMap().registerSprite(new ResourceLocation("akhaten:blocks/machines/machine_tardis"));
    }

    public void postInit(FMLPostInitializationEvent event) {

        super.postInit(event);

    }


}
