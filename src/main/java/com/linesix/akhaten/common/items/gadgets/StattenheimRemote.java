package com.linesix.akhaten.common.items.gadgets;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.items.ItemBase;
import com.linesix.akhaten.common.items.ItemNames;
import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.common.sound.SoundRegistry;
import com.linesix.akhaten.util.tardis.Tardfile;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StattenheimRemote extends ItemBase {

	public StattenheimRemote() {
		super(ItemNames.Gadgets.stattenheim_remote, ItemNames.Gadgets.stattenheim_remote, Gadgets.gadtab);	
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if(player.isSneaking()) {
				ItemStack stack = player.getHeldItem(hand);
				NBTTagCompound nbt = stack.getTagCompound();
				
				if (nbt == null) 
					nbt = new NBTTagCompound();
				
				if (!nbt.hasKey("ID")) {
					try {
						nbt.setInteger("ID", Tardfile.getTardisIDFromTardfile(Tardfile.findparseTardfileByName(player.getName())));
						stack.setStackDisplayName("Stattenheim Remote ("+nbt.getInteger("ID")+")");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(nbt.getInteger("ID"));
			}
			
			try {
				JsonObject tardfile = Tardfile.findparseTardfileByName(player.getName()); // Load the users Tardfile
				
				if (!Tardfile.getTardisStateFromTardFile(tardfile)[0]) {
					int[] oldCoords = Tardfile.getCoordsFromTardfile(tardfile);
					BlockPos oldCoordsPos = new BlockPos(oldCoords[0], oldCoords[1], oldCoords[2]);
					worldIn.playSound(null, oldCoords[0], oldCoords[1], oldCoords[2], SoundRegistry.registerSound("", SoundRegistry.sound_paths[0]), SoundCategory.BLOCKS, 1.0f, 1.0f);
					worldIn.setBlockState(oldCoordsPos, Blocks.AIR.getDefaultState(), 3);
					
					// Update the users Tardfile
					Tardfile.updateTardfile(Tardfile.findTardfileByName(player.getName()), player.getName(), Tardfile.getTardisIDFromTardfile(tardfile), 
							Tardfile.getUUIDFromTardfile(tardfile), Tardfile.getIntCoordsFromTardfile(tardfile), new int[] {pos.up().getX(), pos.up().getY(), pos.up().getZ()}, 
							Tardfile.getSetCoordsFromTardfile(tardfile), 
							Tardfile.getDimensionFromTardfile(tardfile), 
							Tardfile.getSetDimensionFromTardfile(tardfile), 
							Tardfile.getTardisStateFromTardFile(tardfile));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundRegistry.registerSound("", SoundRegistry.sound_paths[1]), SoundCategory.BLOCKS, 1.0f, 1.0f);
			worldIn.setBlockState(pos.up(), MachineBlocks.machine_tardis.getDefaultState(), 3);
			
			return EnumActionResult.SUCCESS;
			
		}
		
		return EnumActionResult.PASS;
	}
	
}
