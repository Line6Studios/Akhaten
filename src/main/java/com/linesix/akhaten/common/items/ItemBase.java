package com.linesix.akhaten.common.items;

import com.linesix.akhaten.common.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String name, String unlocalizedName, CreativeTabs tab) {

        setUnlocalizedName(getUnlocalizedName(unlocalizedName));
        setRegistryName(Reference.RESOURCE_PREFIX + name);
        setCreativeTab(tab);

    }

    public String getUnlocalizedName(String in) {

        return "item." + Reference.RESOURCE_PREFIX + in;

    }

}
