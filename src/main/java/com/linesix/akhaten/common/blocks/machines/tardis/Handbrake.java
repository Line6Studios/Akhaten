package com.linesix.akhaten.common.blocks.machines.tardis;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.sound.SoundRegistry;
import com.linesix.akhaten.util.tardis.Tardfile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.io.File;
import java.io.IOException;

public class Handbrake extends Block {

    public Handbrake() {

        super(Material.ANVIL);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.handbrake);
        setCreativeTab(MachineBlocks.machineblocktab);

    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.handbrake;

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        // This method handles de- and rematerialising of tardises---
        float dematSoundPitch = 0.8f;
        float rematSoundPitch = 1.0f;

        // Load and parse the Tardfile
        File tardfilePath = tardfilePath = Tardfile.findTardfileByName(playerIn.getName());
        JsonObject tardfile;

        tardfile = Tardfile.parseTardfileByName(playerIn.getName());
        if (tardfile == null) {
        	return true;
        }

        // Create variables for all required properties of the Tardfile
        int[] intCoords, setCoords, oldCoords;
        int setX, setY, setZ, x, y, z;
        int dim, setDim;
        int id;
        boolean[] tardisState;

        // Write the tardfile property variables
        intCoords = Tardfile.getIntCoordsFromTardfile(tardfile);
        setCoords = Tardfile.getSetCoordsFromTardfile(tardfile);
        oldCoords = Tardfile.getCoordsFromTardfile(tardfile);

        setX = setCoords[0];
        setY = setCoords[1];
        setZ = setCoords[2];

        x = oldCoords[0];
        y = oldCoords[1];
        z = oldCoords[2];

        tardisState = Tardfile.getTardisStateFromTardFile(tardfile);
        dim = Tardfile.getDimensionFromTardfile(tardfile);
        setDim = Tardfile.getSetDimensionFromTardfile(tardfile);
        id = Tardfile.getTardisIDFromTardfile(tardfile);
        // ---------------------------------------------------------

        // De- / Rematerialise it if it's serverside
        if (!worldIn.isRemote) {
            if (tardisState[1]) { // If the TARDIS isn't dematerialised, demat it
                worldIn.playSound(null, pos, new SoundEvent(new ResourceLocation(Reference.MODID, SoundRegistry.sound_paths[0])), SoundCategory.BLOCKS, 10.0f, dematSoundPitch);

                BlockPos oldPos = new BlockPos(x, y, z); // Generate new  BlockPos for old Tardis position
                try {
                    Tardfile.updateTardfile(tardfilePath, playerIn.getName(), id, playerIn.getUniqueID().toString(), intCoords, setCoords, setCoords, dim, setDim,new boolean[] {true, false});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DimensionManager.getWorld(dim).destroyBlock(oldPos, false);
            } else if (tardisState[0]) { // If the TARDIS isn't materialised, remat it
                worldIn.playSound(null, pos, SoundRegistry.registerSound("", SoundRegistry.sound_paths[1]), SoundCategory.BLOCKS, 1.0f, rematSoundPitch);

                BlockPos newPos = new BlockPos(setX, setY, setZ); // Generate BlockPos for new Tardis position
                try {
                    Tardfile.updateTardfile(tardfilePath, playerIn.getName(), id, playerIn.getUniqueID().toString(), intCoords, oldCoords, setCoords, dim, setDim, new boolean[] {false, true});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DimensionManager.getWorld(setDim).setBlockState(newPos, MachineBlocks.machine_tardis.getDefaultState());

            }
            return true;
        } else {
            return true;
        }

    }

}
