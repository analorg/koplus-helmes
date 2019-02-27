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
        String word = args[1];
        char[] wordChar = word.toLowerCase().toCharArray();
        Arrays.sort(wordChar);
        int sizeWord = wordChar.length;

        ArrayList<String> result = new ArrayList<>();
        String[] inputList = getInputList(args[0]);
        System.out.println("Finished file loading: " + (System.currentTimeMillis() - startTime));

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
        System.out.println("Finished parsing: " + (System.currentTimeMillis() - startTime));
        long stop = System.currentTimeMillis() - startTime;
        System.out.println(stop*1000 + ", " + String.join(",", result));
    }

    private static String[] getInputList(String path) throws IOException {
        Charset inputCharset = Charset.forName("ISO-8859-1");

        return Files.readAllLines(Paths.get(path), inputCharset).toArray(new String[0]);
    }
}
