package com.linesix.akhaten.util;

import com.google.gson.JsonObject;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Tardfile {

    /* Tardfile creation and update class
     *
     * This class is used to create and update "tardFiles"
     * Information on tardFiles can be found under the github Akhaten wiki!
     *
     * Author: Felix Eckert (TheBertrahmPlays / Angry German)
     *
     */

    public TardfileTemplate tardfileTemplate;

    /**
     * Generates a simple Tardfile using PrintWriter.
     *
     * @throws FileNotFoundException if the json file / the "tardises" directory could not be found
     *
     */
    public static void genTardfile(World worldIn, BlockPos pos, EntityLivingBase placer, File path) throws FileNotFoundException {

        if (path.exists()) {

            System.out.println("Generating tardFile for user" + placer.getName() + "...");

            int id = (path).list().length + 1;
            id = id - 1;

            File pathComplete = new File(FileUtil.combine(path.getPath(), "/tardFile_" + placer.getName() + ".json")); // Create the whole path

            // If the user already owns a tardFile, prevent him from entering the new TARDIS and prompt him to delete his old
            if (pathComplete.exists()) {

                placer.sendMessage(new TextComponentString("You already have a TARDIS! To delete it type /delete-tardis (W.I.P.)"));
                worldIn.destroyBlock(pos, true);

                return;

            }

            PrintWriter writer = new PrintWriter(pathComplete); // Create a new PrintWriter for the tardfile

            String[] tardfilearray = createTardFileArray(placer.getName(), placer.getUniqueID().toString(), id, pos.getX(), pos.getY(), pos.getZ()); // Create the array containing all base information

            for (String i : tardfilearray) { // Write the file from the array

                writer.write(i+"\n");

            }

            writer.close();

            try {

                if (replaceChar(pathComplete)) {

                    return;

                } else {

                    placer.sendMessage(new TextComponentString("A critical error has occured and the tardFile could not be written, try again later!"));
                    worldIn.destroyBlock(pos, true);
                    return;

                }

            } catch (IOException e) {

                e.printStackTrace();
                placer.sendMessage(new TextComponentString("A critical error has occured and the tardFile could not be written, try again later!"));
                return;

            }

        } else {

            path.mkdir();
            return;

        }

    }

    /**
     * Updates a tardfile
     *
     * @param data The JsonObject of the tardfile to update
     * @param coords The current coordinates of the tardis
     * @param setCoords The coordinates that were set for the tardis
     * @param tardis_state The state of the tardis (demat / remat)
     *
     */
    public static JsonObject updatedTardfile(JsonObject data, int[] coords, int[] setCoords, boolean[] tardis_state) {

        String[] properties = {"is_demat", "is_remat", "x", "y", "z", "setX", "setY", "setZ"};

        for (String property : properties) { // Removes every property that's in properties[]

            data.remove(property);

        }

        // Messy code but it does the job xD

        for (String property : properties) { // Loops through every property in properties[] and creates it

            if (property == properties[0]) {

                data.addProperty(property, tardis_state[0]);

            } else if (property == properties[1]) {

                data.addProperty(property, coords[0]);

            } else if (property == properties[2]) {

                data.addProperty(property, coords[1]);

            } else if (property == properties[3]) {

                data.addProperty(property, coords[2]);

            } else if (property == properties[4]) {

                data.addProperty(property, setCoords[0]);

            } else if (property == properties[5]) {

                data.addProperty(property, setCoords[1]);

            } else if (property == properties[6]) {

                data.addProperty(property, setCoords[2]);

            } else {

                data.addProperty(property, tardis_state[1]);

            }

        }

        return data;

    }

    /**
     * Replaces all single-quotes in a JSON file with double-quotes
     *
     * @param path path to the JSON file
     *
     * @throws IOException
     *
     */
    public static boolean replaceChar(File path) throws IOException {

        String json = new String(Files.readAllBytes(Paths.get(path.getPath()))); // Read the single-line json file to a String

        String newJSON = json.replaceAll("\\'", Character.toString('"')); // Replace all instances of the single quote with a double quote

        // Delete the old file
        if (!path.delete()) {

            System.out.println("Couldn't delete JSON file! Returning...");
            return false;

        }

        PrintWriter writer = new PrintWriter(path); // Create a new PrintWriter

        writer.write(newJSON); // Write the new JSON

        writer.close();

        return true;

    }

    /**
     * Mainly used by the delete-tardis command
     *
     * @param path path to the file to delete
     * @param user user that called the command
     *
     */
    public static void deleteTardFile(File path, ICommandSender user, World world) {

        try {

            JsonObject data = FileUtil.parseJSON(path);

            int[] coords = getCoordsFromTardfile(data);

            int x = coords[0];
            int y = coords[1];
            int z = coords[2];

            BlockPos tardisBlockPos = new BlockPos(x, y, z);

            world.destroyBlock(tardisBlockPos, true);

            path.delete();
            user.sendMessage(new TextComponentString("Succesfully deleted your old TARDIS!"));

        } catch (Exception e) {

            System.out.println("An Error occured whilst deleting tardis of player " + user.getName() + "!");
            user.sendMessage(new TextComponentString("An error occured whilst deleting your TARDIS!"));
            e.printStackTrace();
            return;

        }

    }

    /**
     * Create the "Tardfile array" that is going to be written to the JSON file...
     *
     * @param user Name of the user that placed the tardis
     * @param uuid uuid of the user that placed the tardis
     * @param tardis_id ID of the tardis
     * @param x the current x coordinate of the tardis
     * @param y the current y coordinate of the tardis
     * @param z the current z coordinate of the tardis
     *
     */
    private static String[] createTardFileArray(String user, String uuid, int tardis_id, int x, int y, int z) {

        String[] template;
        template = new String[]{

                "{\n  'user':'" + user + "',",
                "  'uuid':'" + uuid +  "',",
                "  'tardis_id':'"  + tardis_id +  "',",
                "  'is_demat':'false',",
                "  'is_remat':'true',",
                "  'x':'"  + x +  "',",
                "  'y':'"  + y +  "',",
                "  'z':'" + z +  "',",
                "  'setX':'"  + x +  "',",
                "  'setY':'"  + y +  "',",
                "  'setZ':'" + z +  "'\n}"

        };

        return template;

    }

    // Tardfile field getters below

    public static int[] getCoordsFromTardfile(JsonObject data) {

        int[] coords = {data.get("x").getAsInt(), data.get("y").getAsInt(), data.get("z").getAsInt()};

        return coords;

    }

    public static boolean[] getTardisStateFromTardFile(JsonObject data) {

        return new boolean[]{data.get("is_demat").getAsBoolean(), data.get("is_remat").getAsBoolean()};

    }

    public static int[] getSetCoordsFromTardfile(JsonObject data) {

        int[] setCoords = {data.get("setX").getAsInt(), data.get("setY").getAsInt(), data.get("setZ").getAsInt()};

        return setCoords;

    }

    public static int getTardisIDFromTardfile(JsonObject data) {

        return data.get("tardis_id").getAsInt();

    }

    public static String getUUIDFromTardfile(JsonObject data) {

        return data.get("uuid").getAsString();

    }

}
