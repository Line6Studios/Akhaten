package com.linesix.akhaten.common.blocks.machines.tardis.tardiscore;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TardisCore extends Block {
    public TardisCore() {
        super(Material.IRON);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.tardis_core;}
}