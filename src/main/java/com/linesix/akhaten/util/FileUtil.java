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

    public static String combine(String path1, String path2) {

        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();

    }

    public static JsonObject parseJSON(File path) throws IOException {

        String rawData = new String(Files.readAllBytes(Paths.get(path.getPath())));

        JsonObject data = new Gson().fromJson(rawData, JsonObject.class);

        return data;

    }

}
