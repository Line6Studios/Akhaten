package com.linesix.akhaten.common.blocks.building.tardis;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CoralWall extends Block {

    public CoralWall() {
        super(Material.ROCK);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Other.coral_wall);
        setCreativeTab(BuildingBlocks.buildblocktab);
        setSoundType(SoundType.STONE);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Other.coral_wall;}

}
