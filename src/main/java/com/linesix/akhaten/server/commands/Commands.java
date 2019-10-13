package com.linesix.akhaten.server.commands;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class Commands {

   /* Command registration class
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
    *
    */

    public static CommandDeleteTardis delete_tardis;
    public static CommandSetCoordinates set_coordinates;
    public static CommandAddCompanion add_companion;

    public static void init() {
        delete_tardis = new CommandDeleteTardis();
        set_coordinates = new CommandSetCoordinates();
        add_companion = new CommandAddCompanion();
    }

    public static void register(FMLServerStartingEvent event) {
        init();

        event.registerServerCommand(delete_tardis);
        event.registerServerCommand(set_coordinates);
        event.registerServerCommand(add_companion);
    }

}
