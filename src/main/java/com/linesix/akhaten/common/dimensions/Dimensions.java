package com.linesix.akhaten.common.dimensions;

import com.linesix.akhaten.common.Reference;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class Dimensions {

   /* Akhaten Dimension registration Class
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    * Dimensions:
    *   com.linesix.akhaten.common.dimensions.DimensionTardis <-- Tardis Dimension
    *
    */

    private static List<Biome> BIOMES = new ArrayList<>();

    public static final void registerDimensions() {

        DimensionTardis.register(); // Register Tardis Dimension

    }

}
