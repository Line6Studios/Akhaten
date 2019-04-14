package com.linesix.akhaten.items.gadgets;

import com.linesix.akhaten.items.Gadgets;
import com.linesix.akhaten.items.ItemBase;
import com.linesix.akhaten.items.ItemNames;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class VortexManipulator extends ItemBase {

    public VortexManipulator() {

        super(ItemNames.Gadgets.vortex_manipulator, ItemNames.Gadgets.vortex_manipulator, Gadgets.gadtab);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        System.out.println("VortexManipulater used by player " + player);

        if (player.dimension == 0) {

            player.attackEntityFrom(DamageSource.MAGIC, 2);
            player.changeDimension(1);

        } else {

            player.attackEntityFrom(DamageSource.MAGIC, 2);
            player.changeDimension(0);

        }

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));


    }

}
