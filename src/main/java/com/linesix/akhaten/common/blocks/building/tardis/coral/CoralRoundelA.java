package com.linesix.akhaten.common.blocks.building.tardis.coral;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class CoralRoundelA extends Block {
	public CoralRoundelA() {
        super(Material.ROCK);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Coral.coral_roundel_a);
        setCreativeTab(BuildingBlocks.buildblocktab);
        setSoundType(SoundType.STONE);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Coral.coral_roundel_a;}

}
