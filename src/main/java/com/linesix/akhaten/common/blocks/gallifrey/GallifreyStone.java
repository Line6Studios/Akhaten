package com.linesix.akhaten.common.blocks.gallifrey;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.common.blocks.DimBlocks;
import com.linesix.akhaten.common.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GallifreyStone extends Block {

    public GallifreyStone() {

        super(Material.ROCK);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_stone);
        setCreativeTab(DimBlocks.dimblocktab);

    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_stone;

    }

}
