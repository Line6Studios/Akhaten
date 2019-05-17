package com.linesix.akhaten.tabs;

import com.linesix.akhaten.common.items.Gadgets;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabGadgets extends CreativeTabs {

    public TabGadgets() {

        super("akhaten_gadgets");

    }

    @Override
    public ItemStack getTabIconItem() {

        return new ItemStack(Gadgets.vortex_manipulator);

    }
}
