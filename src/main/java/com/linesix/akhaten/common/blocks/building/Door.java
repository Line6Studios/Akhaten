package com.linesix.akhaten.common.blocks.building;

import java.io.IOException;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import com.linesix.akhaten.common.dimensions.DimensionTardis;
import com.linesix.akhaten.util.AkhatenTeleporter;
import com.linesix.akhaten.util.tardis.Tardfile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Door extends Block {

    public Door() {

        super(Material.WOOD);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.door);
        setCreativeTab(BuildingBlocks.buildblocktab);

    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.door;

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if(!worldIn.isRemote) { // If it's server side go on

        	JsonObject data = null;
        	try {
        		data = Tardfile.findparseTardfileByName(playerIn.getName());
        	} catch (IOException e) {
        		playerIn.sendMessage(new TextComponentString("An error occured, if you're unable to exit the TARDIS, use a Vortex Manipulator!"));
        		return true;
        	}
        	
            boolean isDemat = Tardfile.getTardisStateFromTardFile(data)[0]; // Get the demat state
            int[] coordinates = Tardfile.getCoordsFromTardfile(data); // Get the current tardis coordinates

            WorldServer dimension = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(
                    Tardfile.getDimensionFromTardfile(data)); // Get the dimension of the TARDIS as a WorldServer

            if (!isDemat && playerIn.dimension == DimensionTardis.ID_TARDIS) { // If the player is in the TARDIS Dimension and the Tardis isn't dematerialized, go on

                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn,
                        Tardfile.getDimensionFromTardfile(data), new AkhatenTeleporter(dimension, coordinates[0], coordinates[1], coordinates[2])); // Teleport the player

            } else {

                playerIn.sendMessage(new TextComponentString("You cannot leave your TARDIS while it is dematerialised!"));

            }

        }

        return true;

    }

}
