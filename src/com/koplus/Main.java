package com.koplus;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String userWord = args[1];
        char[] userWordArr = userWord.toLowerCase().toCharArray();
        Arrays.sort(userWordArr);
        int sizeWord = userWordArr.length;

        ArrayList<String> result = new ArrayList<>();
        String[] inputList = getInputList(args[0]);

        int listSize = inputList.length;
        for(int i = 0; i < listSize; i++) {
            String word1 = inputList[i];
            if (word1.length() != sizeWord) continue;
            char[] currentWord = word1.toLowerCase().toCharArray();

            Arrays.sort(currentWord);

            if (Arrays.equals(currentWord, userWordArr)) {
                result.add(inputList[i]);
            }
        }
        System.out.println((System.currentTimeMillis() - startTime) + " " + String.join(",", result));
    }

    private static String[] getInputList(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), Charset.forName("WINDOWS-1257")).toArray(new String[0]);
    }
}
