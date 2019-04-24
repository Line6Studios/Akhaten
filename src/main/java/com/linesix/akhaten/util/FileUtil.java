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

}
