package com.linesix.akhaten.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tardfile {

   /* Tardfile creation and update class
    *
    * This class is used to create and update "tardFiles"
    * Information on tardFiles can be found under the github Akhaten wiki
    *
    * Author: Felix Eckert (TheBertrahmPlays / Angry German)
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

                writer.write(i);

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

    // Used to replace the single quote with a double quote
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

    private static String[] createTardFileArray(String user, String uuid, int tardis_id, float x, float y, float z) {

        String[] template;
        template = new String[]{

                "{'user':'" + user + "',",
                "'uuid':'" + uuid +  "',",
                "'tardis_id':'"  + tardis_id +  "',",
                "'x':'"  + x +  "',",
                "'y':'"  + y +  "',",
                "'z':'" + z +  "'}"

        };

        return template;

    }

}
