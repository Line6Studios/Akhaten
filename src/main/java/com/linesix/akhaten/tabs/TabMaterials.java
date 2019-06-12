package com.linesix.akhaten.tabs;

import com.linesix.akhaten.common.items.registries.Materials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMaterials extends CreativeTabs {

    public TabMaterials() {
        super("akhaten_materials");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Materials.electronic_circuit);
    }

}
