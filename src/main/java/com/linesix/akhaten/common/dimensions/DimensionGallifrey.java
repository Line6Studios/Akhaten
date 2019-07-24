package com.linesix.akhaten.common.dimensions;

import com.linesix.akhaten.common.dimensions.worldproviders.WorldProviderGallifrey;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionGallifrey {
	
   /* Gallifrey Dimension Class
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    * See these other classes:
    *   com.linesix.akhaten.common.dimensions.chunkgenerators.ChunkGeneratorGallifrey
    *   com.linesix.akhaten.common.dimensions.worldproviders.WorldProviderGallifrey
    *
    */

    public static int ID_GALLIFREY = DimensionManager.getNextFreeDimId();;
    public static final String GALLIFREY_NAME = "gallifrey";
    public static DimensionType GALLIFREY_DIM = DimensionType.register(GALLIFREY_NAME, "_"+GALLIFREY_NAME, ID_GALLIFREY, WorldProviderGallifrey.class, false);

    public static void register() {
        DimensionManager.registerDimension(ID_GALLIFREY, GALLIFREY_DIM);
    }

}
