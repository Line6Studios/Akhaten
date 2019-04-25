package com.linesix.akhaten.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
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

        File file2 = new File(path1.getPath(), path2.getPath());
        return file2.getPath();

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

}
