package com.linesix.akhaten.commands;

import com.linesix.akhaten.util.FileUtil;
import com.linesix.akhaten.util.Tardfile;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.io.File;
import java.io.IOException;

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

        try {

            int id = Tardfile.findparseTardfileByName(sender.getName()).get("tardis_id").getAsInt();
            int[] coords = Tardfile.getCoordsFromTardfile(FileUtil.parseJSON(Tardfile.findTardfileByName("Lord_Bertrahm")));
            int[] setCoords = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};

            Tardfile.updateTardfile(Tardfile.findTardfileByName(sender.getName()), sender.getName(), id,
                    sender.getCommandSenderEntity().getUniqueID().toString(), coords, setCoords,
                    Tardfile.getTardisStateFromTardFile(Tardfile.findparseTardfileByName("Lord_Bertrahm")));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
