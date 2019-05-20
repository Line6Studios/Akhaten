package com.linesix.akhaten.common.blocks.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemHartnellRoundel extends ItemBlock {

    /*
    * This is the class for the Hartnell Roundel Item,
    * it is required since the Hartnell Roundel has
    * blockstates which require this class!
    *
    * Author: Felix Eckert ( Angry German / TheBertrahmPlays )
    *
    */

    public ItemHartnellRoundel(Block block) {

        super(block);

        if(!(block instanceof IMetaBlockName)) {

            throw new IllegalArgumentException(
                    String.format("The given Block %s is not an instace of IMetaBlockName", block.getUnlocalizedName()));

        }

        this.setHasSubtypes(true);
        this.setMaxDamage(0);

    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return super.getUnlocalizedName() + "." + ((IMetaBlockName) this.block).getSpecialName(stack);


    }

}
