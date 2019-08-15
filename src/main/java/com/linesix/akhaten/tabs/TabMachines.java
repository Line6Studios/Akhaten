package com.linesix.akhaten.tabs;

import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMachines extends CreativeTabs {
    public TabMachines() {
        super("akhaten_machines");
    }
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(MachineBlocks.machine_tardis);
    }
}
