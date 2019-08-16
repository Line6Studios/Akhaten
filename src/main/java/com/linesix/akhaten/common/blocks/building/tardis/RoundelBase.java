package com.linesix.akhaten.common.blocks.building.tardis;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RoundelBase extends Block {
    private String rv;
    public RoundelBase(String roundelVersion) {
        super(Material.IRON);
        this.rv = roundelVersion;

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + rv);
        setCreativeTab(BuildingBlocks.buildblocktab);
        setSoundType(SoundType.METAL);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + rv;}
}
