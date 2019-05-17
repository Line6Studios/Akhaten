package com.linesix.akhaten.tabs;

import com.linesix.akhaten.common.blocks.BuildingBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabBuilding extends CreativeTabs {

        public TabBuilding() {

            super("akhaten_building_blocks");

        }

        @Override
        public ItemStack getTabIconItem() {

            return new ItemStack(BuildingBlocks.block_roundel);

        }

}
