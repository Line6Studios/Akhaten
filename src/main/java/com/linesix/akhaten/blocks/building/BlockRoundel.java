package com.linesix.akhaten.blocks.building;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRoundel extends Block {

    public BlockRoundel() {

        super(Material.IRON);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.roundel);
        setCreativeTab(DimBlocks.dimblocktab);
        setSoundType(SoundType.METAL);

    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.roundel;

    }

}
