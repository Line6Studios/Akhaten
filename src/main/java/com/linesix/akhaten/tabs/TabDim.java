package com.linesix.akhaten.tabs;

import com.linesix.akhaten.blocks.DimBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabDim extends CreativeTabs {

    public TabDim() {

        super("akhaten_dimensional_blocks");

    }

    @Override
    public ItemStack getTabIconItem() {

        return new ItemStack(DimBlocks.gallifrey_stone);

    }
}
