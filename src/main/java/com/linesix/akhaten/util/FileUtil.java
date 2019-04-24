package com.linesix.akhaten.util;

import com.google.gson.Gson;

import java.io.*;

public class FileUtil {

    public static String combine(String path1, String path2) {

        File file1 = new File(path1);
        File file2 = new File(file1, path2);
        return file2.getPath();

    }

    public static Object parseJson(FileReader path) {

        BufferedReader bufferedReader = new BufferedReader(path);

        Gson gson = new Gson();
        Object json = gson.fromJson(bufferedReader, Object.class);

        return json;

    }

}
