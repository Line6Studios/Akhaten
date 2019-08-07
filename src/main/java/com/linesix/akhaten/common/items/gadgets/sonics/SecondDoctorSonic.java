package com.linesix.akhaten.common.items.gadgets.sonics;

import com.linesix.akhaten.common.items.ItemNames;
import com.linesix.akhaten.common.items.gadgets.SonicBase;
import com.linesix.akhaten.common.sound.SoundRegistry;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class SecondDoctorSonic extends SonicBase {
    public SecondDoctorSonic() {
        super(ItemNames.Gadgets.seconddoctor_sonic);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            BlockPos hit = new BlockPos(hitX, hitY, hitZ);
            IBlockState block = worldIn.getBlockState(pos);
            worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundRegistry.registerSound("", SoundRegistry.sound_paths[2]), SoundCategory.BLOCKS, 1.0f, 1.0f);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.SUCCESS;
    }
}
