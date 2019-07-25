package com.linesix.akhaten.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

    /**
     * Combines 2 File (paths) to one path
     *
     * @param path1 first part of the path
     * @param path2 second part of the path to be combined
     *
     */
    public static String combine(File path1, File path2) {
        File file = new File(path1.getPath(), path2.getPath());
        return file.getPath();
    }

    /**
     * Writes a file from an Array
     *
     * @param file The path for the file
     * @param input The array to be written
     * @param endlMod Modifiers for end of the Line, look at com.linesix.akhaten.util.FileUtil.LineMods
     *
     * @throws FileNotFoundException
     * @throws FileAlreadyExistsException
     *
     * */
    public static void writeFileFromArray(File file, String[] input, int endlMod) throws FileNotFoundException, FileAlreadyExistsException {
        if (file.exists())
            throw new FileAlreadyExistsException("The file "+file.getPath()+" already exists!");

        PrintWriter writer = new PrintWriter(file);

        for (String i : input) { // Write the file from the array
            writer.write(i+"\n");
        }

        writer.close();
    }

    public static void writeFile(File file, String input) throws FileNotFoundException, FileAlreadyExistsException {
        if (file.exists())
            throw new FileAlreadyExistsException("The file "+file.getPath()+" already exists!");

        PrintWriter writer = new PrintWriter(file);
        writer.write(input);
        writer.close();
    }

    /**
     * Parses a json file and returns it as an JsonObject
     *
     * @param path Path to the JsonFile
     *
     */
    public static JsonObject parseJSON(File path) throws IOException {
        String rawData = new String(Files.readAllBytes(Paths.get(path.getPath())));
        JsonObject data = new Gson().fromJson(rawData, JsonObject.class);

        return data;
    }

    public static class LineMods {
        public static int NO_MOD = 0;
        public static int LN_BREAK = 1;
    }
}
