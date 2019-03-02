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
        String word = args[1];
        char[] wordChar = word.toLowerCase().toCharArray();
        Arrays.sort(wordChar);
        int sizeWord = wordChar.length;

        ArrayList<String> result = new ArrayList<>();
        String[] inputList = getInputList(args[0]);
        SimpleTimer.split("Done file loading");

        int listSize = inputList.length;
        for(int i = 0; i < listSize; i++) {
            String word1 = inputList[i];
            if (word1.length() != sizeWord) continue;
            char[] currentWord = word1.toLowerCase().toCharArray();

            Arrays.sort(currentWord);

            if (Arrays.equals(currentWord, wordChar)) {
                result.add(inputList[i]);
            }
        }
        SimpleTimer.split("Done parse");
        SimpleTimer.printResults();
        System.out.println( String.join(",", result));
    }

    private static String[] getInputList(String path) throws IOException {
        Charset inputCharset = Charset.forName("WINDOWS-1257");

        return Files.readAllLines(Paths.get(path), inputCharset).toArray(new String[0]);
    }
}
