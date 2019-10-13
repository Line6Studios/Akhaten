package com.linesix.akhaten.common.blocks.machines.tardis;

import com.google.gson.JsonObject;
import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.registries.MachineBlocks;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.dimensions.DimensionTardis;
import com.linesix.akhaten.util.AkhatenTeleporter;
import com.linesix.akhaten.util.FileUtil;
import com.linesix.akhaten.util.tardis.Tardfile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class MachineTardis extends Block {
    private UUID owner = null; //UUID of player.
    private int[] coords = null;

    public MachineTardis() {
        super(Material.WOOD);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.machine_tardis);
        setCreativeTab(MachineBlocks.machineblocktab);
        setBlockUnbreakable();
    }

    @Override
    public String getUnlocalizedName() { return "tile."+Reference.RESOURCE_PREFIX + Names.Machines.machine_tardis; }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            JsonObject playerTardfile;

            try { // Load the Tardfile of the Tardis by Coordinates
                int id = Tardfile.getTardisIDByXYZ(new int[] {pos.getX(), pos.getY(), pos.getZ()},
                        playerIn.getName());
                playerTardfile = Tardfile.parseTardfileByID(id);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            // Check if the TARDIS belongs to the player, of if he's a companion, if not return.
            if (!playerTardfile.get("user").getAsString().matches(playerIn.getName()) && !Tardfile.isCompanion(new File(DimensionManager.getCurrentSaveRootDirectory()+"/tardises/tardFile_"+playerTardfile.get("user").getAsString()), playerIn.getName())) {
                playerIn.sendMessage(new TextComponentString("§4This TARDIS belongs to §6"+playerTardfile.get("user").getAsString()));
                return false;
            }


            int[] intCoords = Tardfile.getIntCoordsFromTardfile(playerTardfile); // TARDIS interior coordinates
            WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(playerIn.dimension); // Get the worldserver for the teleportation

            if (Tardfile.getFirstTimeLoadingTD(playerTardfile)) { // If it's the first time of him entering the TARDIS, place a Stone Block
                playerIn.getServer().getWorld(DimensionTardis.ID_TARDIS).setBlockState(new BlockPos(intCoords[0], intCoords[1]-1, intCoords[2]), Blocks.STONE.getDefaultState(), 3);
            }

            worldIn.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) playerIn,
                    DimensionTardis.ID_TARDIS, new AkhatenTeleporter(worldServer, intCoords[0]+0.5, intCoords[1], intCoords[2]+0.5)); // Teleporting

            return true;
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (worldIn.provider.getDimension() == DimensionTardis.ID_TARDIS) {
            worldIn.destroyBlock(pos, true);
        } else {
            if (placer instanceof EntityPlayer || placer instanceof EntityPlayerMP) {
                if (!worldIn.isRemote) {
                    Reference.logger.info("Player "+placer.getName()+" placed a TARDIS, generating...");

                    owner = placer.getUniqueID();
                    File saveRootDIR = worldIn.getSaveHandler().getWorldDirectory().getAbsoluteFile();

                    String fullPath = FileUtil.combine(saveRootDIR, new File("tardises"));
                    File tardFile = new File(fullPath);
                    if (tardFile.exists()){}
                    else {
                        tardFile.mkdir();
                    }

                    try {
                        Tardfile.genTardfile(worldIn, pos, placer, tardFile);
                    } catch (FileNotFoundException | NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                worldIn.destroyBlock(pos, false);
            }
        }
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }
}
