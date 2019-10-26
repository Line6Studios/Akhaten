package com.linesix.akhaten.server.commands;

import com.linesix.akhaten.util.tardis.Tardfile;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;

import java.io.File;

public class CommandAddCompanion extends CommandBase {
    @Override
    public String getName() {
        return "add-companion";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        File file = new File(DimensionManager.getCurrentSaveRootDirectory() + "/tardises/tardFile_"+sender.getName()+".json");
        Tardfile.addCompanionToTardfile(file, args[0]);
    }
}
