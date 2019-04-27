package com.linesix.akhaten.blocks.machines.tardisblocks;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.blocks.Names;
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

        System.out.println("TARDIS dematerialising");

        return true;

    }

}
