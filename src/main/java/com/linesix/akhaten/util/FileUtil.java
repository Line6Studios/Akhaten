package com.linesix.akhaten.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class FileUtil {

    public static String combine(String path1, String path2) {

        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();

    }

    public static List<TardfileTemplate> parseTardfileJSON(FileReader path) {

        final Type TYPE = new TypeToken<List<TardfileTemplate>>() {}.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(path);

        List<TardfileTemplate> data = gson.fromJson(reader, TYPE);

        return data;

    }

}
