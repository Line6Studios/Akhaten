package com.linesix.akhaten.dimensions;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.dimensions.worldproviders.WorldProviderTardis;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Dimensions {

   /* Akhaten Dimension registration Class
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    * Dimensions:
    *   com.linesix.akhaten.dimensions.DimensionTardis <-- Tardis Dimension
    *
    */

    private static List<Biome> BIOMES = new ArrayList<>();

    public static final void registerDimensions() {

        DimensionTardis.register(); // Register Tardis Dimension

    }

}
