package com.linesix.akhaten.common.items.gadgets;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.items.ItemBase;
import com.linesix.akhaten.common.items.ItemNames;
import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.util.tardis.Tardfile;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StattenheimRemote extends ItemBase {

	public StattenheimRemote() {
		super(ItemNames.Gadgets.stattenheim_remote, ItemNames.Gadgets.stattenheim_remote, Gadgets.gadtab);	
	}

	@Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			try {
				JsonObject tardfile = Tardfile.findparseTardfileByName(player.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			Vec3d lookingAt = player.getLookVec();
			int x = (int) lookingAt.x;
			int y = (int) lookingAt.y;
			int z = (int) lookingAt.z;
			
			BlockPos pos = new BlockPos(x, y, z);
			
			world.setBlockState(pos, MachineBlocks.machine_tardis.getDefaultState(), 1);
			System.out.println("Test");
			
			return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
			
		}
		return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
	
}
