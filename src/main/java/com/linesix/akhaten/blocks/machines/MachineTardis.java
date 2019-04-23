package com.linesix.akhaten.blocks.machines;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.MachineBlocks;
import com.linesix.akhaten.blocks.Names;
import com.linesix.akhaten.dimensions.DimensionTardis;
import com.linesix.akhaten.util.AkhatenTeleporter;
import com.linesix.akhaten.util.FileUtil;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileNotFoundException;

public class MachineTardis extends Block {

    public MachineTardis() {

        super(Material.IRON);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.machine_tardis);
        setCreativeTab(MachineBlocks.machineblocktab);

    }

    @Override
    public String getUnlocalizedName() {

        return "machine_tile." + Reference.RESOURCE_PREFIX + Names.Machines.machine_tardis;

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {

            float playerX = playerIn.getPosition().getX();
            float playerY = playerIn.getPosition().getY();
            float playerZ = playerIn.getPosition().getZ();

            int lastDim = worldIn.provider.getDimension();

            WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(playerIn.dimension);

            if (playerIn.dimension == DimensionTardis.ID_TARDIS) {

                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn,
                        lastDim, new AkhatenTeleporter(worldServer, playerX, playerY, playerZ));

            } else {

                worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn,
                        DimensionTardis.ID_TARDIS, new AkhatenTeleporter(worldServer, playerX, playerY, playerZ));

            }

            return true;

        } else {

            return true;

        }

    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        if (worldIn.provider.getDimension() == DimensionTardis.ID_TARDIS) {

            worldIn.destroyBlock(pos, true);

        } else {

            if (placer instanceof EntityPlayer || placer instanceof EntityPlayerMP) {

                placer.sendMessage(new TextComponentString("Congratulations for getting your own Type 40 TT Capsule!"));

                File saveRootDIR = DimensionManager.getCurrentSaveRootDirectory();

                String fullPath = FileUtil.combine(saveRootDIR.getPath(), "tardises");
                File tardFile = new File(fullPath);
                try {

                    FileUtil.tardFile(worldIn, pos, placer, tardFile);

                } catch (FileNotFoundException e) {

                    e.printStackTrace();

                }

            } else {

                worldIn.destroyBlock(pos, false);

            }

        }


    }


}
