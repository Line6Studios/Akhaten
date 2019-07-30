package com.linesix.akhaten.common.items.gadgets;

import com.linesix.akhaten.common.items.registries.Gadgets;
import com.linesix.akhaten.common.items.ItemBase;
import com.linesix.akhaten.common.items.ItemNames;
import com.linesix.akhaten.util.AkhatenTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class VortexManipulator extends ItemBase {

    private int teleportDamageAmount = 2; // Damage that is applied when teleported

    public VortexManipulator() {

        super(ItemNames.Gadgets.vortex_manipulator, ItemNames.Gadgets.vortex_manipulator, Gadgets.gadtab);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

        float playerX = player.getPosition().getX();
        float playerY = player.getPosition().getY();
        float playerZ = player.getPosition().getZ();

        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);

        

        if (!world.isRemote) {
            if (player.dimension == 0) {

                player.attackEntityFrom(DamageSource.MAGIC, teleportDamageAmount);

                world.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) player,
                        -1, new AkhatenTeleporter(worldServer, playerX, playerY, playerZ));

            } else {

                player.attackEntityFrom(DamageSource.MAGIC, teleportDamageAmount);

                world.getMinecraftServer().getPlayerList().transferPlayerToDimension((EntityPlayerMP) player,
                        0, new AkhatenTeleporter(worldServer, playerX, playerY, playerZ));

            }

            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));

        }

        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));

    }

}
