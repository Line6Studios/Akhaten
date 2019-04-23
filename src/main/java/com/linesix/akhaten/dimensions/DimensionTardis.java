package com.linesix.akhaten.dimensions;

import com.linesix.akhaten.dimensions.worldproviders.WorldProviderTardis;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionTardis {

   /* Tardis Dimension Class
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    * See these other classes:
    *   com.linesix.akhaten.dimensions.chunkgenerators.ChunkGeneratorTardis
    *   com.linesix.akhaten.dimensions.worldproviders.WorldProviderTardis
    *
    */

    public static int ID_TARDIS = DimensionManager.getNextFreeDimId();;
    public static final String TARDIS_NAME = "tardis";
    public static DimensionType TARDIS_DIM = DimensionType.register(TARDIS_NAME, "_"+TARDIS_NAME, ID_TARDIS, WorldProviderTardis.class, false);

    public static void register() {

        DimensionManager.registerDimension(ID_TARDIS, TARDIS_DIM);

    }

}
