package com.linesix.akhaten.common.blocks.machines.tardis;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.MachineBlocks;
import com.linesix.akhaten.common.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TardisMonitor extends Block {

    public TardisMonitor() {
        super(Material.IRON);
        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.monitor);
        setCreativeTab(MachineBlocks.machineblocktab);
    }

    @Override
    public String getUnlocalizedName() {
        return "machine_tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.monitor;
    }

}
