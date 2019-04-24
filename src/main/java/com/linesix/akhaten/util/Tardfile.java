package com.linesix.akhaten.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

            File pathComplete = new File(FileUtil.combine(path.getPath(), "/tardFile_" + placer.getName() + ".json")); // Create the whole path

            PrintWriter writer = new PrintWriter(pathComplete); // Create a new PrintWriter for the tardfile

            String[] tardfilearray = createTardFileArray(placer.getName(), placer.getUniqueID().toString(), id, pos.getX(), pos.getY(), pos.getZ()); // Create the array containing all base information

            for (String i : tardfilearray) { // Write the file from the array

                writer.write(i);

            }

            writer.close();


        } else {

            path.mkdir();
            return;

        }

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
