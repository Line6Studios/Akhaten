package com.linesix.akhaten.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandSetCoordinates extends CommandBase {

    @Override
    public String getName() {

        return "set-tard-coordinates";

    }

    @Override
    public String getUsage(ICommandSender sender) {

        return "Missing argument! Required <x> <y> <z>";

    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {



    }

}
