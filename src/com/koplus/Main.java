package com.koplus;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        SimpleTimer.start();
        String userWord = args[1];
        char[] userWordArr = userWord.toLowerCase().toCharArray();
        Arrays.sort(userWordArr);
        int sizeWord = userWordArr.length;

        ArrayList<String> result = new ArrayList<>();
        SimpleTimer.split("Start file loading");
        String[] inputList = getInputList(args[0]);
        SimpleTimer.split("Done file loading");

        int listSize = inputList.length;
        SimpleTimer.split("Starting loop");
        for(int i = 0; i < listSize; i++) {
            String word1 = inputList[i];
            if (word1.length() != sizeWord) continue;
            char[] currentWord = word1.toLowerCase().toCharArray();

            Arrays.sort(currentWord);

            if (Arrays.equals(currentWord, userWordArr)) {
                result.add(inputList[i]);
            }
        }
        SimpleTimer.split("Done parse");
        SimpleTimer.printResults();
        System.out.println( String.join(",", result));
    }

    private static String[] getInputList(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), Charset.forName("WINDOWS-1257")).toArray(new String[0]);
    }
}
