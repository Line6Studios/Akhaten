package com.linesix.akhaten.common.dimensions.worldproviders;

import com.linesix.akhaten.common.dimensions.chunkgenerators.ChunkGeneratorGallifrey;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderGallifrey extends WorldProvider {

	public WorldProviderGallifrey() {
		
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorGallifrey(this.world);
	}
	
	@Override
	public DimensionType getDimensionType() {
		return null;
	}

}
