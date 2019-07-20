package com.linesix.akhaten.common.blocks.gallifrey;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.DimBlocks;
import com.linesix.akhaten.common.blocks.Names;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GallifreyGrass extends Block {

    public GallifreyGrass() {

        super(Material.GRASS);
        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_grass);
        setCreativeTab(DimBlocks.dimblocktab);
        setSoundType(SoundType.PLANT);
        setHardness(0.6F);
        
    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_grass;

    }

}
