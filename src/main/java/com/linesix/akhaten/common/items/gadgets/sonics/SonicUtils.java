package com.linesix.akhaten.common.items.gadgets.sonics;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SonicUtils {
    public static void toggleIronDoor(IBlockState state, BlockPos pos, World worldIn) {
        int metaState = Blocks.IRON_DOOR.getMetaFromState(state);

        if (metaState == 8 || metaState == 9) {
            metaState = Blocks.IRON_DOOR.getMetaFromState(worldIn.getBlockState(pos.down()));
        }

        if (metaState < 4) {
            Blocks.IRON_DOOR.toggleDoor(worldIn, pos, true);
        } else if (metaState == 4 || metaState == 11 || metaState == 10 || metaState > 4 && metaState < 8) {
            Blocks.IRON_DOOR.toggleDoor(worldIn, pos, false);
        }
    }
}
