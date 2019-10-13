package com.linesix.akhaten.common.blocks.machines.tardis;

import com.linesix.akhaten.client.gui.TestGui;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TardisMonitor extends Block {
    public TardisMonitor() {
        super(Material.IRON);
        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.monitor);
        setCreativeTab(MachineBlocks.machineblocktab);
    }

    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.monitor;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            Minecraft.getMinecraft().displayGuiScreen(new TestGui());
            return true;
        }

        return false;
    }
}
