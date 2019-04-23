package com.linesix.akhaten.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileUtil {

    public static String combine(String path1, String path2) {

        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();

    }

    public static void tardFile(World worldIn, BlockPos pos, EntityLivingBase placer, File path) throws FileNotFoundException {

        if (path.exists()) {

            System.out.println("creating tardFile for user" + placer.getName() + "...");

            int id = (path).list().length + 1;

            File pathComplete = new File(path.getPath() + "/tardFile_" + placer.getName() + ".json");

            PrintWriter writer = new PrintWriter(pathComplete);

            String[] tardfilearray = createTardFileArray(placer.getName(), placer.getUniqueID().toString(), id, pos.getX(), pos.getY(), pos.getZ());

            for (String i : tardfilearray) {

                writer.write(i);
                placer.sendMessage(new TextComponentString(i));

            }

            writer.close();

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
