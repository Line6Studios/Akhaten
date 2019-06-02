package com.linesix.akhaten.common.blocks.building.tardis;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CoralWire extends Block {

    public CoralWire() {
        super(Material.IRON);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Other.coral_wiring);
        setCreativeTab(BuildingBlocks.buildblocktab);
        setSoundType(SoundType.METAL);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Other.coral_wiring;}

}
