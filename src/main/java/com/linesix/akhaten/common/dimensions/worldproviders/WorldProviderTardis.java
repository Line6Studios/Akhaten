package com.linesix.akhaten.common.dimensions.worldproviders;

import com.linesix.akhaten.common.dimensions.DimensionTardis;
import com.linesix.akhaten.common.dimensions.chunkgenerators.ChunkGeneratorTardis;
import com.linesix.akhaten.common.dimensions.renderes.TardisDimRenderer;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderTardis extends WorldProvider {

    public WorldProviderTardis() {
    }

    @Override
    public IChunkGenerator createChunkGenerator() {

        return new ChunkGeneratorTardis(this.world, this.world.getSeed());

    }

    @Override
    public DimensionType getDimensionType() {

        return DimensionTardis.TARDIS_DIM;

    }

    @Override
    public boolean canRespawnHere() {

        return true;

    }

    @Override
    public IRenderHandler getCloudRenderer() {

        return new TardisDimRenderer();

    }

}
