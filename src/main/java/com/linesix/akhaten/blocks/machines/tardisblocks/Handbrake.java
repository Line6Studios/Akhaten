package com.linesix.akhaten.blocks.machines.tardisblocks;

import com.google.gson.JsonObject;
import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.blocks.Names;
import com.linesix.akhaten.blocks.machines.MachineTardis;
import com.linesix.akhaten.util.Tardfile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

        if (!worldIn.isRemote) {

            System.out.println("TARDIS dematerialising");

            JsonObject tardfile = Tardfile.findTardfileByName(playerIn.getName());

            int[] setCoords;
            int setX, setY, setZ;

            int[] oldCoords;
            int x, y, z;

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

            if (!tardisState[0]) { // If the TARDIS isn't dematerialised, demat it

                BlockPos oldPos = new BlockPos(x, y, z); // Generate new  BlockPos for old Tardis position
                Tardfile.updatedTardfile(tardfile, oldCoords, setCoords, new boolean[] {true, false});
                worldIn.destroyBlock(oldPos, false);

            } else if (!tardisState[1]) { // If the TARDIS isn't materialised, remat it

                BlockPos newPos = new BlockPos(setX, setY, setZ); // Generate BlockPos for new Tardis position
                Tardfile.updatedTardfile(tardfile, oldCoords, setCoords, new boolean[] {false, true});
                worldIn.setBlockState(newPos, MachineBlocks.machine_tardis.getDefaultState());

            }

            return true;

        } else {

            return true;

        }



    }

}
