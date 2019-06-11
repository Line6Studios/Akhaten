package com.linesix.akhaten.server.commands;

import com.linesix.akhaten.util.tardis.Tardfile;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;

import java.io.File;

public class CommandDeleteTardis extends CommandBase {

    @Override
    public String getName() {

        return "delete-tardis";

    }

    @Override
    public String getUsage(ICommandSender sender) {

        return null;

    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        EntityPlayerMP player = (EntityPlayerMP) sender;

        Tardfile.deleteTardFile(new File(DimensionManager.getCurrentSaveRootDirectory().getPath() + "/tardises/tardFile_"+sender.getName()+".json"), sender, server.getWorld(player.dimension));

    }

}
