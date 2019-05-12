package com.linesix.akhaten.blocks.machines.tardisblocks;

import com.google.gson.JsonObject;
import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.blocks.Names;
import com.linesix.akhaten.blocks.machines.MachineTardis;
import com.linesix.akhaten.sound.SoundRegistry;
import com.linesix.akhaten.util.FileUtil;
import com.linesix.akhaten.util.Tardfile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Handbrake extends Block {

    public Handbrake() {

        super(Material.ANVIL);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.handbrake);
        setCreativeTab(MachineBlocks.machineblocktab);

    }

    @Override
    public String getUnlocalizedName() {

        return "machine_tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.handbrake;

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        Random r = new Random();

        float soundPitch = 0.1f + r.nextFloat() * (1.5f - 0.1f);

        File tardfilePath = Tardfile.findTardfileByName(playerIn.getName());
        JsonObject tardfile = Tardfile.findparseTardfileByName(playerIn.getName());

        int[] setCoords;
        int setX, setY, setZ;

        int[] oldCoords;
        int x, y, z;

        int dim = 0;

        int id;

        boolean[] tardisState;

        if (tardfile == null) {

            return false;

        }

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

        id = Tardfile.getTardisIDFromTardfile(tardfile);

        if (!worldIn.isRemote) {

            if (tardisState[1]) { // If the TARDIS isn't dematerialised, demat it

                worldIn.playSound(null, pos, new SoundEvent(new ResourceLocation(Reference.MODID, SoundRegistry.sound_paths[0])), SoundCategory.BLOCKS, 10.0f, soundPitch);

                System.out.println(SoundRegistry.sound_events.get(1).getSoundName().toString());

                BlockPos oldPos = new BlockPos(x, y, z); // Generate new  BlockPos for old Tardis position
                try {
                    Tardfile.updateTardfile(tardfilePath, playerIn.getName(), id, playerIn.getUniqueID().toString(), setCoords, setCoords, new boolean[] {true, false});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DimensionManager.getWorld(dim).destroyBlock(oldPos, false);

            } else if (tardisState[0]) { // If the TARDIS isn't materialised, remat it

                worldIn.playSound(null, pos, SoundRegistry.registerSound("", SoundRegistry.sound_paths[1]), SoundCategory.BLOCKS, 1.0f, soundPitch);

                BlockPos newPos = new BlockPos(setX, setY, setZ); // Generate BlockPos for new Tardis position
                try {
                    Tardfile.updateTardfile(tardfilePath, playerIn.getName(), id, playerIn.getUniqueID().toString(), oldCoords, setCoords, new boolean[] {false, true});
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DimensionManager.getWorld(dim).setBlockState(newPos, MachineBlocks.machine_tardis.getDefaultState());

            }

            return true;

        } else {

            return true;

        }



    }

}
