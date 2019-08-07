package com.linesix.akhaten.common.items.gadgets;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.Reference;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class StattenheimRemote extends ItemBase {

	public StattenheimRemote() {
		super(ItemNames.Gadgets.stattenheim_remote, ItemNames.Gadgets.stattenheim_remote, Gadgets.gadtab);	
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			ItemStack stack = player.getHeldItem(hand);
			NBTTagCompound nbt = stack.getTagCompound();
			if(player.isSneaking()) {
				int id = 0;
				try {
					id = Tardfile.getTardisIDByXYZ(new int[] {pos.getX(), pos.getY(), pos.getZ()}, player.getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (id == -1) {
					player.sendMessage(new TextComponentString("This TARDIS is not your own, thus you cannot bind it!"));
				} else if(id == -2) {
					player.sendMessage(new TextComponentString("An unknown error occured whilst trying to bind your TARDIS!"));
					Reference.logger.warning("An (unknown) error occured whilst trying to bind a TARDIS to a Stattenheim Remote!");
				}
				
				if (nbt == null) 
					nbt = new NBTTagCompound();
				
				if (!nbt.hasKey("ID")) {
					nbt.setInteger("ID", id);
				} else {
					nbt.removeTag("ID");
					nbt.setInteger("ID", id);
				}
				
				stack.setTagCompound(nbt);
				stack.setStackDisplayName("Stattenheim Remote ("+nbt.getInteger("ID")+")");
				return EnumActionResult.PASS;
			}
			
			try {
				if (!nbt.hasKey("ID")) {
					player.sendMessage(new TextComponentString("You need to bind your TARDIS before summoning it using the Stattenheim Remote"));
					return EnumActionResult.SUCCESS;
				}
				System.out.println(nbt.getInteger("ID"));
				JsonObject tardfile = Tardfile.parseTardfileByID(nbt.getInteger("ID")); // Load the users Tardfile
				if (tardfile == null) {
					player.sendMessage(new TextComponentString("Something went wrong whilst loading your Tardfile, send your latest.log to the mod-authors for help!"));
					return EnumActionResult.FAIL;
				}

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
